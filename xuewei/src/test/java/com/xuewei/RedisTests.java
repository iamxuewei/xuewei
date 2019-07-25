package com.xuewei;

import com.xuewei.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Resource
    RedisTemplate redisTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * 解决Spring Boot 使用RedisTemplate 存储键值出现乱码 \xac\xed\x00\x05t\x00
     * @param redisTemplate
     */
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Test
    public void redis(){
        stringRedisTemplate.opsForValue().append("admin","123456");
       String s = stringRedisTemplate.opsForValue().get("zhang");
       System.out.println(s);
       stringRedisTemplate.delete("zhang");

//        Map<String, String> map = new HashMap<String, String>();
//		map.put("id", "1");
//		map.put("name", "zxw");
//		map.put("age", "22");
//		map.put("qq", "123456");
//        redisTemplate.opsForHash().putAll("zxw",map);

    }

}
