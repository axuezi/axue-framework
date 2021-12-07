package com.axue.framework.boot.plugin.email.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author axue
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "email")
public class EmailConfigProperties {

    private String mailSmtpHost = "mailSmtpHost";

    private String mailSmtpUsername = "mailSmtpUsername";

    private String mailSmtpPassword = "mailSmtpPassword";

    private String siteName = "siteName";

}
