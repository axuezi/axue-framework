package com.axue.framework.boot.plugin.storage.entity;

import lombok.Data;

@Data
public class SysConfigStorage {

    /**
     * 存储类型1、阿里OSS；2、七牛云；3、本地
     */
    private String storageType;

    /**
     * 地域节点
     */
    private String endpoint;

    /**
     * accessKeyId
     */
    private String accessKeyId;

    /**
     * 密钥
     */
    private String accessKeySecret;

    /**
     * 域名
     */
    private String bucket;

}
