package com.xuewei.controller;

import com.xuewei.mongodb.service.HisService;
import com.xuewei.mongodb.vo.His;
import com.xuewei.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/crud")
public class CrudController extends BaseController {

    @Autowired
    public HisService hisService;

    /**
     *进入crud
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String main(Model model){
        User user = this.getThisUser();
        return "pages/crud";
    }


}
