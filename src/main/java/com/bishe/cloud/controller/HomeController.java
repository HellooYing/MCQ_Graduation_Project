package com.bishe.cloud.controller;

import com.bishe.cloud.model.HostHolder;
import com.bishe.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Created by bishe.cloud on 2016/7/2.
 */
@Controller
public class HomeController {
    @Resource
    UserService userService;

    @Resource
    HostHolder hostHolder;

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model,@RequestParam(value = "pop", defaultValue = "0") int pop) {
        model.addAttribute("pop", pop);
        return "home";
    }

    @RequestMapping(path = {"/user/{userId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String userIndex(Model model, @PathVariable("userId") int userId) {
        return "home";
    }


}
