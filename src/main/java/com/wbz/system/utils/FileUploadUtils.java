package com.wbz.system.utils;


import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils
{
    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;

    /**
     * 默认的文件名最大长度 100
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 100;

    public static final String extractFilename(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String extension = getExtension(file);
//        fileName = DateUtils.datePath() + "/" + IdUtils.fastUUID() + "." + extension;
        fileName = IdUtils.fastUUID() + "." + extension;
        return fileName;
    }

    /**
     * 获取文件名的后缀
     *
     * @param file 表单文件
     * @return 后缀名
     */
    public static final String getExtension(MultipartFile file) {
        String extension = FileNameUtils.getExtension(file.getOriginalFilename());
        if (BeanUtils.isEmpty(extension)) {
            extension = getExtension(file.getContentType());
        }
        return extension;
    }

    public static String getExtension(String prefix) {
        byte var2 = -1;
        switch(prefix.hashCode()) {
            case -1487394660:
                if (prefix.equals("image/jpeg")) {
                    var2 = 2;
                }
                break;
            case -879272239:
                if (prefix.equals("image/bmp")) {
                    var2 = 3;
                }
                break;
            case -879267568:
                if (prefix.equals("image/gif")) {
                    var2 = 4;
                }
                break;
            case -879264467:
                if (prefix.equals("image/jpg")) {
                    var2 = 1;
                }
                break;
            case -879258763:
                if (prefix.equals("image/png")) {
                    var2 = 0;
                }
        }

        switch(var2) {
            case 0:
                return "png";
            case 1:
                return "jpg";
            case 2:
                return "jpeg";
            case 3:
                return "bmp";
            case 4:
                return "gif";
            default:
                return "";
        }
    }
}
