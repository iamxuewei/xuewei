package com.xuewei.controller;

import com.xuewei.job.AsyncTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    AsyncTest asyncTest;

    @RequestMapping("/yiBu")
    public String yiBu() throws InterruptedException {
        asyncTest.yiBu();
        return "success";
    }

    @RequestMapping("/tongBu")
    public String tongBu() throws InterruptedException {
        asyncTest.tongBu();
        return "success";
    }

}
