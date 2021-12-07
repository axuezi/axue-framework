package com.axue.framework.boot.plugin.storage.util;

import com.axue.framework.boot.plugin.storage.entity.StorageConfig;
import com.axue.framework.boot.plugin.storage.entity.SysConfigStorage;

import java.io.File;

/**
 * 文件上传工具类
 *
 * @author axue
 */
public class UploadFileUtils {

    /**
     * 上传文件
     *
     * @param file             文件
     * @param dir              用户上传文件时指定的文件夹。
     * @param sysConfigStorage 云存储类型
     */
    public static String uploadFile(File file, String dir, SysConfigStorage sysConfigStorage) throws Exception {
        StorageConfig storageConfig = new StorageConfig();
        storageConfig.setAccessKeyId(sysConfigStorage.getAccessKeyId());
        storageConfig.setAccessKeySecret(sysConfigStorage.getAccessKeySecret());
        storageConfig.setEndpoint(sysConfigStorage.getEndpoint());
        storageConfig.setBucket(sysConfigStorage.getBucket());
        if ("1".equals(sysConfigStorage.getStorageType())) {
            // 阿里OSS
            AliOssUtils aliOssUtils = new AliOssUtils(storageConfig);
            return aliOssUtils.uploadFile(file, dir);
        } else if ("2".equals(sysConfigStorage.getStorageType())) {
            // 七牛云
            QiNiuUtils qiNiuUtils = new QiNiuUtils(storageConfig);
            return qiNiuUtils.uploadFile(file, dir);
        } else if ("3".equals(sysConfigStorage.getStorageType())) {
            // minio
            MinioUtils minioUtils = new MinioUtils(storageConfig);
            return minioUtils.uploadFile(file, dir);
        } else if ("4".equals(sysConfigStorage.getStorageType())) {
            // 腾讯cos
            QcloudCosUtils qcloudCosUtils = new QcloudCosUtils(storageConfig);
            return qcloudCosUtils.uploadFile(file, dir);
        }
        return "";
    }

}
