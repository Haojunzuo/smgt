package com.wbz.system.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ISysFileService {

    public String uploadFile(MultipartFile file, String bucketName) throws Exception;

    public void downloadFile(HttpServletResponse response, String[] fileNames) throws Exception;

    public void delete(String[] fileNames) throws Exception;

    public List<Object> listBucket() throws Exception;

    public List<Object> list(String name) throws Exception;

    public String makeBucket(String bucketName) throws Exception;

    public String removeBucket(String bucketName) throws Exception;

    public Object getTagByFile(String bucketName, String fileName) throws Exception;
}
