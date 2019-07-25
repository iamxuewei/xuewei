package com.xuewei.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @描述:
 * @作者: Zhangxuewei
 * @包名: com.example.springcloudconsume.config
 * @日期: 2018-06-2018/6/8 15:57
 * @修改: 无
 */
@Configuration
public class RestTemplateConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
