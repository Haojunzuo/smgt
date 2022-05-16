package com.wbz.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.wbz.system.config.MinioConfig;
import com.wbz.system.service.ISysFileService;
import com.wbz.system.utils.FileUploadUtils;
import io.minio.*;
import io.minio.messages.*;
//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

//import org.apache.tomcat.util.http.fileupload.IOUtils;


@Service
public class MinioSysFileServiceImpl implements ISysFileService
{
    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient client;

    @Override
    public List<Object> listBucket() throws Exception {
        List<Bucket> bucketList = client.listBuckets();
        List<Object> items = new ArrayList<>();
        String format = "{'id':%d,'label':'%s'}";
        int id = 1;
        for (Bucket bucket : bucketList) {
//            System.out.println(bucket.creationDate() + ", " + bucket.name());
            items.add(JSON.parse(String.format(format,id++,bucket.name())));
        }
//        System.out.println(items);
        return items;
    }

    @Override
    public List<Object> list(String name) throws Exception {
        Iterable<Result<Item>> myObjects = client.listObjects(ListObjectsArgs.builder().bucket(name).build());
        Iterator<Result<Item>> iterator = myObjects.iterator();
        List<Object> items = new ArrayList<>();
        String format = "{'fileName':'%s','fileSize':'%s','date':'%s','description':'%s'}";
        while (iterator.hasNext()){
            Item item = iterator.next().get();
            Tags tags = client.getObjectTags(
                    GetObjectTagsArgs.builder().bucket(name).object(item.objectName()).build());
            items.add(JSON.parse(String.format(format,item.objectName(),getSize(item.size()),item.lastModified().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),tags.get().get("description"))));
        }
        System.out.println(items);
        return items;
    }

    @Override
    public String makeBucket(String bucketName) throws Exception {
        boolean isExist = client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if(isExist) {
            return "0";
        } else {
            String s = String.format("{\"Version\":\"2012-10-17\"," +
                    "\"Statement\":[{\"Effect\":\"Allow\"," +
                    "\"Principal\":{\"AWS\":[\"*\"]}," +
                    "\"Action\":[\"s3:ListBucketMultipartUploads\",\"s3:GetBucketLocation\",\"s3:ListBucket\"]," +
                    "\"Resource\":[\"arn:aws:s3:::%s\"]}," +
                    "{\"Effect\":\"Allow\"," +
                    "\"Principal\":{\"AWS\":[\"*\"]}," +
                    "\"Action\":[\"s3:ListMultipartUploadParts\",\"s3:PutObject\",\"s3:AbortMultipartUpload\",\"s3:DeleteObject\",\"s3:GetObject\"]," +
                    "\"Resource\":[\"arn:aws:s3:::%s/*\"]}]}",bucketName,bucketName);

            client.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build());
            client.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(s).build());
        }
        return "1";
    }

    @Override
    public String removeBucket(String bucketName) throws Exception {
        boolean isExist = client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if(isExist) {
            client.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        } else {
            return "0";
        }
        return "1";
    }

    @Override
    public Object getTagByFile(String bucketName, String fileName) throws Exception {
        Tags tags = client.getObjectTags(
                GetObjectTagsArgs.builder().bucket(bucketName).object(fileName).build());
        System.out.println(Long.valueOf(tags.get().get("date")));
        String format = "{'description':'%s','uid': %d}";
        System.out.println(JSON.parse(String.format(format,tags.get().get("description"),Long.valueOf(tags.get().get("date")))));
        return JSON.parse(String.format(format,tags.get().get("description"),Long.valueOf(tags.get().get("date"))));
    }

    /**
     * 本地文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadFile(MultipartFile file, String bucketName) throws Exception
    {
        boolean isExist = client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!isExist) {
            makeBucket(bucketName);
        }
        String fileName = FileUploadUtils.extractFilename(file);
        Map<String, String> map = new HashMap<>();
        if(file.getOriginalFilename()!=null){
//            String[] tags = file.getOriginalFilename().split("\\.");
            map.put("description", file.getOriginalFilename());
            map.put("date", String.valueOf(new Date().getTime()));
        }
        InputStream in = file.getInputStream();
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .stream(in, file.getSize(), -1)
                .contentType(file.getContentType())
                .build();
        client.putObject(args);
        client.setObjectTags(
                SetObjectTagsArgs.builder().bucket(bucketName).object(fileName).tags(map).build());
        in.close();


//        String url = client.getPresignedObjectUrl(
//                GetPresignedObjectUrlArgs.builder()
//                .method(Method.PUT)
//                .bucket(bucketName)
//                .object(fileName)
//                .expiry(1, TimeUnit.DAYS)
//                .build());
//        System.out.println(url);

        return fileName;
    }

    /**
     * 本地文件下载接口
     *
     * @param fileNames 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public void downloadFile(HttpServletResponse response, String[] fileNames) throws Exception{

        for (String fullFileName:fileNames){
            String bucket = fullFileName.split("_")[0];
            String fileName = fullFileName.split("_")[1];
            InputStream in = null;
            try{
                StatObjectResponse statObjectResponse = client.statObject(
                        StatObjectArgs.builder().bucket(bucket).object(fileName).build()
                );
                byte[] buf = new byte[1024];
                int length = 0;
                response.reset();
                System.out.println(statObjectResponse.contentType());
                response.setContentType(statObjectResponse.contentType());
                response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
//                response.setContentType("application/octet-stream");
//                response.setHeader("Content-Disposition","attachment;filename="+ fileName);
                response.setCharacterEncoding("UTF-8");
                in = client.getObject(
                        GetObjectArgs.builder()
                                .bucket(bucket)
                                .object(fileName)
                                .build()
                );
//                IOUtils.copy(in,response.getOutputStream());
                OutputStream outputStream = response.getOutputStream();
                while ((length = in.read(buf)) > 0) {
                    outputStream.write(buf, 0, length);
                }
                outputStream.close();
            } catch (Exception e){
                System.out.println(e);
            } finally {
                if(in!=null){
                    try{
                        in.close();
                    } catch (Exception e){
                        System.out.println(e);
                    }
                }
            }


        }
    }

//    @Override
//    public void view(HttpServletResponse response, String OFileName) throws Exception {
//        String bucket = OFileName.split("_")[0];
//        String fileName = OFileName.split("_")[1];
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        try{
//            StatObjectResponse statObjectResponse = client.statObject(
//                    StatObjectArgs.builder().bucket(bucket).object(fileName).build()
//            );
//            byte[] buf = new byte[1024];
//            int len;
////            response.reset();
////            response.setContentType(statObjectResponse.contentType());
//            response.setContentType("image/jpeg;charset=utf-8");
//            inputStream =client.getObject(
//                    GetObjectArgs.builder()
//                            .bucket(bucket)
//                            .object(fileName)
//                            .build()
//            );
//            outputStream = response.getOutputStream();
//            while ((len = inputStream.read(buf)) > 0) {
//                outputStream.write(buf, 0, len);
//            }
//            response.flushBuffer();
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        } finally {
//            if (inputStream != null) {
//                try {
//                    System.out.println("inputStream not empty");
//                    inputStream.close();
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//            if (outputStream != null) {
//                try {
//                    System.out.println("outputStream not empty");
//                    outputStream.close();
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//
//    }

    @Override
    public void delete(String[] fileNames) throws Exception {
        List<DeleteObject> objects = new LinkedList<>();
        String bucket = null;
        for (String fullFileName:fileNames){
            bucket = fullFileName.split("_")[0];
            String fileName = fullFileName.split("_")[1];
            objects.add(new DeleteObject(fileName));
        }
        Iterable<Result<DeleteError>> results =
                client.removeObjects(
                        RemoveObjectsArgs.builder().bucket(bucket).objects(objects).build());
        for (Result<DeleteError> result : results) {
            DeleteError error = result.get();
            System.out.println(
                    "Error in deleting object " + error.objectName() + "; " + error.message());
        }
    }

    private String getSize(long size){
        DecimalFormat gb = new DecimalFormat("0.00");
        DecimalFormat mb = new DecimalFormat("0.0");
        if(size>=1024*1024*1024){
            return gb.format((double)size / 1073741824L) +" GB";
        }else if(size>=1024*1024){
            return mb.format((double)size / 1048576L) +" MB";
        }else if(size>=1024){
            return (size / 1024) +" KB";
        }else
            return size+" B";
    }
}
