package com.axue.framework.boot.plugin.job.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobProperties {

    /**
     * 开关，默认关闭
     */
    private Boolean enabled = false;

    private XxlAdminProperties admin = new XxlAdminProperties();

    private XxlExecutorProperties executor = new XxlExecutorProperties();

}