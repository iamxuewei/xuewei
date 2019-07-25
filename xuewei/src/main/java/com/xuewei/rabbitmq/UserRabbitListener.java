package com.xuewei.rabbitmq;


import com.xuewei.vo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserRabbitListener {
    @Resource
    RabbitTemplate rabbitTemplate;
    /**
     * 监听，只要队列收到消息便执行方法
     */
//    @RabbitListener(queues = "user")
//    public void AddUserToMysql(User user){
//        System.out.println("插入到mysql数据库="+user.toString());
//    }
//    @RabbitListener(queues = "user.email")
//    public void AddUserToEmail(User user){
//        System.out.println("给用户发邮件");
//    }
//    @RabbitListener(queues = "user.phone")
//    public void AddUserToPhone(User user){
//        System.out.println("给用户发短信");
//    }
}
