package com.bishe.cloud.controller;

import com.bishe.cloud.model.Monitor;
import com.bishe.cloud.model.Pi;
import com.bishe.cloud.service.MonitorService;
import com.bishe.cloud.service.ResponseService;
import com.bishe.cloud.service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/14
 * @time: 2:54 下午
 */
@Controller
public class MonitorController {
    private static final Logger logger = LoggerFactory.getLogger(MonitorController.class);
    @Resource
    ResponseService responseService;
    @Resource
    MonitorService monitorService;
    @Resource
    SensorService sensorService;

    @RequestMapping(path = {"/undoMonitor"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String undoMonitor(@RequestParam("id") Long id) {
        try {
            if(!monitorService.getMonitor(id).getUsing()){
                return "已关闭";
            }
            if(!monitorService.undoMonitor(id)){
                //todo 返回失败
                return "失败";
            }
        } catch (Exception e) {
            logger.error("关闭监控任务错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/doMonitor"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String doMonitor(@RequestParam("id") Long id) {
        try {
            if(monitorService.getMonitor(id).getUsing()){
                return "已开启";
            }
            if(!monitorService.doMonitor(id)){
                //todo 返回失败
                return "失败";
            }
        } catch (Exception e) {
            logger.error("启动监控任务错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/deleteMonitor"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteMonitor(@RequestParam("id") Long id) {
        try {
            monitorService.deleteMonitor(id);
        } catch (Exception e) {
            logger.error("删除监控任务错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/updateMonitor"}, method = {RequestMethod.POST})
    public String updateMonitor(@RequestParam("id") Long id,
                                @RequestParam("sensorId") Long sensorId,
                                @RequestParam("responseDeviceList") String responseDeviceList,
                                @RequestParam("time") String time,
                                @RequestParam("emails") String emails,
                                @RequestParam("sync_num") Integer sync_num) {
        try {
            monitorService.updateMonitor(new Monitor(id, sensorId, responseDeviceList, time, emails, sync_num));
            if (monitorService.getMonitor(id).getUsing()) {
                //如果修改前监控任务正在执行，则通知边缘端更新监控定时任务
            }
        } catch (Exception e) {
            logger.error("修改监控任务错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/addMonitor"}, method = {RequestMethod.POST})
    public String addMonitor(@RequestParam("sensorId") Long sensorId,
                             @RequestParam("responseDeviceList") String responseDeviceList,
                             @RequestParam("time") String time,
                             @RequestParam("emails") String emails,
                             @RequestParam("sync_num") Integer sync_num
    ) {
        try {
            monitorService.addMonitor(new Monitor(sensorId, responseDeviceList, time, emails, sync_num, false, new Date()));
        } catch (Exception e) {
            logger.error("添加监控任务错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/sensorDataRecord"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String sensorDataRecord(Model model) {
        try {
            model.addAttribute("sensorDataRecords", sensorService.getAllRecord());
        } catch (Exception e) {
            logger.error("显示全部监控数据信息错误" + e.getMessage());
        }
        return "home";
    }

    @RequestMapping(path = {"/responseRecord"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String responseRecord(Model model) {
        try {
            model.addAttribute("responseRecords", responseService.getAllRecord());
        } catch (Exception e) {
            logger.error("显示全部响应数据信息错误" + e.getMessage());
        }
        return "home";
    }

    @RequestMapping(path = {"/monitor"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String monitor(Model model) {
        try {
            model.addAttribute("responseRecords", monitorService.getAll());
        } catch (Exception e) {
            logger.error("显示全部监控任务信息错误" + e.getMessage());
        }
        return "home";
    }
}
