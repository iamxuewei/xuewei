package com.xuewei.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthOptionPaneUI;

@Service
@EnableAsync
public class AsyncTest {

    /**
     * 方法需要@Async标注
     * 异步执行，立刻收到返回值
     * 需要在XueweiApplication中开启异步注解@EnableAsync
     * 需要线程池的支持TaskExecutorConfig.java
     * 异步的方法不能和调用的方法写在同一个类中
     * 异步执行一般没有有返回值，如果有返回值也必须是Future<>类型的返回值
     */
    @Async
    public void yiBu() throws InterruptedException {
        //等待三秒
        Thread.sleep(3000);
        System.out.println("开始执行");
    }

    public void tongBu() throws InterruptedException {
        //等待三秒
        Thread.sleep(3000);
        System.out.println("开始执行");
    }
}
