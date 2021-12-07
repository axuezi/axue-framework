package com.axue.framework.boot.plugin.email.config;

import io.github.biezhi.ome.OhMyEmail;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
@AllArgsConstructor
public class EmailConfiguration {

    private final EmailConfigProperties emailConfigProperties;

    /**
     * 邮箱配置初始化
     */
    @PostConstruct
    public void init() {
        String mailHost = emailConfigProperties.getMailSmtpHost();
        String mailUsername = emailConfigProperties.getMailSmtpUsername();
        String mailPassword = emailConfigProperties.getMailSmtpPassword();

        final Properties properties = OhMyEmail.defaultConfig(false);
        properties.setProperty("mail.smtp.host", mailHost);
        OhMyEmail.config(properties, mailUsername, mailPassword);
    }

}
