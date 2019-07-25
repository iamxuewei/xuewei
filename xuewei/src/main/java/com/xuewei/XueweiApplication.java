package com.xuewei;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableRabbit
@EnableCaching
@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
public class XueweiApplication {

	public static void main(String[] args) {
		SpringApplication.run(XueweiApplication.class, args);
	}
}
