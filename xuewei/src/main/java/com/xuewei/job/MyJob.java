package com.xuewei.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
@EnableScheduling
public class MyJob {

    //10分钟定时执行
    @Scheduled(fixedRate = 1000 * 60 *10)
    public void timer(){
        System.out.println("现在时间:  "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

}
