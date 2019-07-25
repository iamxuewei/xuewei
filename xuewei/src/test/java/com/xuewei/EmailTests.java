package com.xuewei;

import com.xuewei.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTests {

    @Resource
    JavaMailSenderImpl javaMailSender;

    /**
     * 简单的email
     */
    @Test
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
    @Test
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
