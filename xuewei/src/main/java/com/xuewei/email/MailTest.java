package com.xuewei.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailTest {

    @Resource
    JavaMailSenderImpl javaMailSender;

    /**
     * 简单的email
     */
    public void sendMail()  {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("测试邮件");
        message.setText("邮件发送成功！");
        message.setTo("hyxdzxw@163.com");
        message.setFrom("zhangxue_wei@qq.com");
        javaMailSender.send(message);
    }

    /**
     * 带html样式，带附件等的邮件
     */
    public void sendMail2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setSubject("测试邮件");
        messageHelper.setText("<div style='color:blue'>邮件发送成功！</div>",true);
        messageHelper.setTo("hyxdzxw@163.com");
        messageHelper.setFrom("zhangxue_wei@qq.com");
        messageHelper.addAttachment("1.jpg",new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\1.jpg"));
        javaMailSender.send(mimeMessage);
    }
}
