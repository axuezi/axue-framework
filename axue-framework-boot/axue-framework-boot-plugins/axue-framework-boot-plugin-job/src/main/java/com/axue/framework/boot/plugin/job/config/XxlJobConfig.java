package com.axue.framework.boot.plugin.job.config;

import com.axue.framework.boot.plugin.job.properties.XxlJobProperties;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xxl Config
 *
 * @author axue
 */
@Configuration
@AllArgsConstructor
public class XxlJobConfig {

    private final XxlJobProperties xxlJobProperties;

    @Bean
    public XxlJobSpringExecutor xxlJobSpringExecutor() {
        if (xxlJobProperties.getEnabled()) {
            XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
            xxlJobSpringExecutor.setPort(xxlJobProperties.getExecutor().getPort());
            xxlJobSpringExecutor.setAdminAddresses(xxlJobProperties.getAdmin().getAddresses());
            xxlJobSpringExecutor.setAppname(xxlJobProperties.getExecutor().getAppname());
            xxlJobSpringExecutor.setAddress(xxlJobProperties.getExecutor().getAddress());
            xxlJobSpringExecutor.setIp(xxlJobProperties.getExecutor().getIp());
            xxlJobSpringExecutor.setAccessToken(xxlJobProperties.getExecutor().getAccessToken());
            xxlJobSpringExecutor.setLogPath(xxlJobProperties.getExecutor().getLogPath());
            xxlJobSpringExecutor.setLogRetentionDays(xxlJobProperties.getExecutor().getLogRetentionDays());
            return xxlJobSpringExecutor;
        }
        return null;
    }

}
