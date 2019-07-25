package com.xuewei;

import com.xuewei.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTests {
    @Resource
    RabbitTemplate rabbitTemplate;
    @Resource
    AmqpAdmin amqpAdmin;
    /**
     * 生产者发送topic，主题模式
     */
    @Test
    public void AddUser()  {
        User user1 = new User();
        user1.setUserId("zhang");
        user1.setPassWord("123456");
        rabbitTemplate.convertAndSend("user.topic","user",user1);//发送消息
        //rabbitTemplate.receiveAndConvert("user");//接收消息
    }

    @Test
    public void Add()  {
        //创建交换器
        //amqpAdmin.declareExchange(new FanoutExchange("user.fanout",true,true));
        //创建队列
        //amqpAdmin.declareQueue(new Queue("test01",true));
        //amqpAdmin.declareQueue(new Queue("test02",true));
        //amqpAdmin.declareQueue(new Queue("test03",true));
        //绑定
        amqpAdmin.declareBinding(new Binding("test01", Binding.DestinationType.QUEUE,"user.fanout","test",null));
        amqpAdmin.declareBinding(new Binding("test02", Binding.DestinationType.QUEUE,"user.fanout","test",null));
        amqpAdmin.declareBinding(new Binding("test03", Binding.DestinationType.QUEUE,"user.fanout","test",null));
    }

}
