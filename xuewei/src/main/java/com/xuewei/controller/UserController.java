package com.xuewei.controller;

import com.xuewei.service.UserService;
import com.xuewei.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;
    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Map<String,Object> map) {
        List<User> result = new ArrayList<User>();
        result = userService.getAllUser();
        map.put("result",result);
        return "pages/user";
    }


    @ResponseBody
    @RequestMapping("/buy")
    public String buy(){
        String s = restTemplate.getForObject("http://EUREKA-PROVIDE/placeOrder",String.class);
        return s;
    }
}
