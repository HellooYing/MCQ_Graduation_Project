package com.bishe.cloud.controller;

import com.bishe.cloud.model.HostHolder;
import com.bishe.cloud.service.*;
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
    ResponseService responseService;
    @Resource
    PiService piService;
    @Resource
    SensorService sensorService;
    @Resource
    MonitorService monitorService;
    @Resource
    HostHolder hostHolder;

    @RequestMapping(path = {"/monitoradd"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String addmonitor(Model model) {
        model.addAttribute("responses",responseService.getAllDevice());
        model.addAttribute("sensors",sensorService.getAllSensor());
        return "addMonitor";
    }

    @RequestMapping(path = {"/responsetypeadd"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String addResponseDeviceType(Model model) {
        return "addResponseType";
    }

    @RequestMapping(path = {"/sensortypeadd"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String addSensorType(Model model) {
        return "addSensorType";
    }

    @RequestMapping(path = {"/dataget"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getData(Model model) {
        model.addAttribute("datas",sensorService.getAllRecord());
        return "getData";
    }

    @RequestMapping(path = {"/piget"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getPi(Model model) {
        model.addAttribute("pis",piService.getAll());
        return "getPi";
    }

    @RequestMapping(path = {"/responseget"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getResponse(Model model) {
        model.addAttribute("responses",responseService.getAllDevice());
        return "getResponse";
    }

    @RequestMapping(path = {"/sensorget"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getSensor(Model model) {
        model.addAttribute("sensors",sensorService.getAllSensor());
        return "getSensor";
    }

    @RequestMapping(path = {"/monitorget"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getMonitor(Model model) {
        model.addAttribute("monitors",monitorService.getAll());
        return "getMonitor";
    }

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model,@RequestParam(value = "pop", defaultValue = "0") int pop) {
        model.addAttribute("pop", pop);

        model.addAttribute("sensors",sensorService.getAllSensor());
        model.addAttribute("sensorData",sensorService.getAllRecord());
        model.addAttribute("pis",piService.getAll());
        model.addAttribute("monitors",monitorService.getAll());
        return "test";
    }

    @RequestMapping(path = {"/user/{userId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String userIndex(Model model, @PathVariable("userId") int userId) {
        return "home";
    }


}
