package com.xuewei.controller;

import com.xuewei.service.UserService;
import com.xuewei.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
    @Resource
    public UserService userService;

    @RequestMapping(value = "/validateUser",method = RequestMethod.GET)
    public String validateUser(@RequestParam(value = "username", defaultValue = "") String username,
                               @RequestParam(value = "password", defaultValue = "") String password,
                               Map<String,Object> map) {
        User user = new User();
        user = userService.getUserByUserId(username);
        if (user != null) {
            if (user.getPassWord().equals(password)) {
                getRequest().getSession().setAttribute("user", user);
                return "redirect:/main/index";
            }
            else {
                map.put("msg","密码错误.");
                return "index";
            }
        }
        map.put("msg","用户不存在.");
        return "index";
    }

    @RequestMapping(value = "/authentication",method = RequestMethod.GET)
    public String index(Map<String,Object> map) {
        map.put("msg","请先登录本系统.");
        return "index";
    }

}
