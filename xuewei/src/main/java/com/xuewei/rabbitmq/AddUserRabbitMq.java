package com.xuewei.rabbitmq;

import com.xuewei.vo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AddUserRabbitMq {

    @Resource
    RabbitTemplate rabbitTemplate;
    /**
     * 生产者发送topic，主题模式
     */
    public void AddUser(User user)  {
        User user1 = new User();
        user1.setUserId("zhang");
        user1.setPassWord("123456");
        rabbitTemplate.convertAndSend("user.topic","user",user1);
    }
}
