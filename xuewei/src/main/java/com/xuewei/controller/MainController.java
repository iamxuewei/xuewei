package com.xuewei.controller;

import com.xuewei.mongodb.dao.HisMongoDao;
import com.xuewei.mongodb.service.HisService;
import com.xuewei.mongodb.vo.His;
import com.xuewei.service.UserService;
import com.xuewei.service.impl.UserServiceImpl;
import com.xuewei.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    @Autowired
    public HisService hisService;
    /**
     *进入首页
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String main(Model model){
        User user = this.getThisUser();
        return "pages/main";
    }

    /**
     *查询mongodb
     */
    @ResponseBody
    @RequestMapping(value = "/queryHis",method = RequestMethod.GET)
    public List<His> queryHis(String num){
        List<His> result = new ArrayList<His>();
        result = hisService.queryHis(num);
        return result;
    }


}
