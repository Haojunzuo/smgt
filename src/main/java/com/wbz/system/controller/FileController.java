package com.wbz.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wbz.system.config.MinioConfig;
import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Data;
import com.wbz.system.domain.SysFile;
import com.wbz.system.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 文件请求处理
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ISysFileService sysFileService;


    @GetMapping("/listBucket")
    public AjaxResult listBucket() throws Exception{
        return AjaxResult.success(sysFileService.listBucket());
    }

    @GetMapping("/listByBucket/{name}")
    public List<Object> listByBucket(@PathVariable String name) throws Exception{
        return sysFileService.list(name);
    }
    /**
     * 桶操作
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody MinioConfig minioConfig) throws Exception {
        System.out.println(minioConfig.getBucketName());
        return AjaxResult.success(sysFileService.makeBucket(minioConfig.getBucketName()));
    }

    @DeleteMapping("/delete/{bucketName}")
    public AjaxResult remove(@PathVariable String bucketName) throws Exception {
        System.out.println(bucketName);
        return AjaxResult.success(sysFileService.removeBucket(bucketName));
    }

    /**
     * 文件上传请求
     * @return
     */
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file, Data data, String bucket)
    {
        String bucketName = data.getBucket();
        if(data.getBucket() == null){
            bucketName = bucket;
        }
        try {
            // 上传并返回访问地址
            String newFile = sysFileService.uploadFile(file,bucketName);
            SysFile sysFile = new SysFile();
            sysFile.setName(newFile);
            sysFile.setUrl(newFile);
            return AjaxResult.success(newFile);
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }


    @RequestMapping("/download/{fileNames}")
    public void download(HttpServletResponse response, @PathVariable String[] fileNames) throws Exception {
        System.out.println(Arrays.toString(fileNames));
        sysFileService.downloadFile(response,fileNames);
    }
    @DeleteMapping("/{fileNames}")
    public void delete(@PathVariable String[] fileNames) throws Exception {
        System.out.println(Arrays.toString(fileNames));
        sysFileService.delete(fileNames);
    }

    @PostMapping("/getTag")
    public AjaxResult getTag(@RequestBody Object object) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(object));
        return AjaxResult.success(sysFileService.getTagByFile(jsonObject.getString("bucketName"),jsonObject.getString("fileName")));
    }

}
