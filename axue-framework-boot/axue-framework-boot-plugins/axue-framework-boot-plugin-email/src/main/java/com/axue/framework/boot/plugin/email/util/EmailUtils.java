package com.axue.framework.boot.plugin.email.util;

import com.axue.framework.boot.plugin.email.config.EmailConfigProperties;
import io.github.biezhi.ome.OhMyEmail;
import io.github.biezhi.ome.SendMailException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

/**
 * 发送邮件工具类
 *
 * @author axue
 */
@Configuration
@AllArgsConstructor
public class EmailUtils {

    private final EmailConfigProperties emailConfigProperties;

    /**
     * 发生邮件
     *
     * @param to      接收人
     * @param title   标题
     * @param content 内容
     */
    public void sendEmail(String to, String title, String content) throws SendMailException {
        OhMyEmail.subject(title)
                .from(emailConfigProperties.getSiteName())
                .to(to)
                .html(content)
                .send();
        System.out.println("email: " + to + " send success");
    }

}
