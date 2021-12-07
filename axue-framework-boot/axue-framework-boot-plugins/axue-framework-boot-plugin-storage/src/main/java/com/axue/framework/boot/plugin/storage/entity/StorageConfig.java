package com.axue.framework.boot.plugin.storage.entity;

import lombok.Data;

/**
 * 存储配置
 *
 * @author axue
 */
@Data
public class StorageConfig {

    /**
     * AccessKeyId
     */
    private String accessKeyId;

    /**
     * AccessKeySecret
     */
    private String accessKeySecret;

    /**
     * endpoint
     */
    private String endpoint;

    /**
     * bucketName
     */
    private String bucket;

}
