package com.axue.framework.boot.plugin.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author axue
 */
@ConfigurationProperties(prefix = "axue.swagger")
public class SwaggerAutoConfigProperties {

    /**
     * 扫包路径
     */
    private String scanPackage;

    /**
     * 标题
     */
    private String title;

    public String getScanPackage() {
        return scanPackage;
    }

    public void setScanPackage(String scanPackage) {
        this.scanPackage = scanPackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
