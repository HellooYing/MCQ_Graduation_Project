package com.bishe.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.bishe.cloud.model.Monitor;
import com.bishe.cloud.model.Sensor;
import com.bishe.cloud.model.SensorDataRecord;
import com.bishe.cloud.service.MonitorService;
import com.bishe.cloud.service.ResponseService;
import com.bishe.cloud.service.SensorService;
import com.bishe.cloud.util.CloudUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    @ResponseBody
    public String undoMonitor(@RequestParam("id") Long id) {
        try {
            if (!monitorService.getMonitor(id).getIsUsing()) {
                return "closed";
            }
            if (!monitorService.undoMonitor(id)) {
                return "failed";
            }
            else{
                return "ok";
            }
        } catch (Exception e) {
            logger.error("关闭监控任务错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/doMonitor"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String doMonitor(@RequestParam("id") Long id) {
        try {
            if (monitorService.getMonitor(id).getIsUsing()) {
                return "doing";
            }
            if (!monitorService.doMonitor(id)) {
                return "failed";
            }
            else{
                return "ok";
            }
        } catch (Exception e) {
            logger.error("启动监控任务错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/deleteMonitor"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteMonitor(@RequestParam("id") Long id) {
        try {
            monitorService.deleteMonitor(id);
        } catch (Exception e) {
            logger.error("删除监控任务错误" + e.getMessage());
        }
        return "ok";
    }

    @RequestMapping(path = {"/updateMonitor"}, method = {RequestMethod.POST})
    @ResponseBody
    public String updateMonitor(@RequestParam("id") Long id,
                                @RequestParam("sensorId") Long sensorId,
                                @RequestParam("responseDeviceList") String responseDeviceList,
                                @RequestParam("time") String time,
                                @RequestParam("emails") String emails,
                                @RequestParam("sync_num") Integer sync_num,
                                @RequestParam("abnormal") String abnormal) {
        try {
            monitorService.updateMonitor(new Monitor(id, sensorId, responseDeviceList, time, emails, sync_num,abnormal));
            if (monitorService.getMonitor(id).getIsUsing()) {
                //如果修改前监控任务正在执行，则通知边缘端更新监控定时任务
            }
        } catch (Exception e) {
            logger.error("修改监控任务错误" + e.getMessage());
        }
        return "ok";
    }

    @RequestMapping(path = {"/addMonitor"}, method = {RequestMethod.POST})
    public String addMonitor(Model model,
                             @RequestParam("sensorId") Long sensorId,
                             @RequestParam("responseDeviceList") String responseDeviceList,
                             @RequestParam("time") String time,
                             @RequestParam("emails") String emails,
                             @RequestParam("sync_num") Integer sync_num,
                             @RequestParam("abnormal") String abnormal
    ) {
        try {
            Monitor monitor = new Monitor(sensorId, responseDeviceList, time, emails, sync_num, false,abnormal);
            monitorService.addMonitor(monitor);
            String result = CloudUtil.sendPost("http://"+monitorService.getUrl(monitor.getId()) + "/addMonitor", monitorService.toMap(monitor));
            if (result.equals("ok")) {
                // 调用成功，状态码1
                model.addAttribute("status",1);
            } else {
                monitorService.deleteMonitor(monitor.getId());
                // 调用边缘设备程序失败，错误码2
                model.addAttribute("status",2);
            }
        } catch (Exception e) {
            // 异常，错误码0
            model.addAttribute("status",0);
            logger.error("添加监控任务错误" + e.getMessage());
        }
        model.addAttribute("monitors",monitorService.getAll());
        return "getMonitor";
    }

    @RequestMapping(path = {"/submit"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submit(@RequestParam("data") String[] data) {
        try {
            List<SensorDataRecord> list=new ArrayList<>();
            SensorDataRecord t=JSON.parseObject(data[0],SensorDataRecord.class);
            Sensor sensor=sensorService.getSensor(t.getSensorId());
            for (int i = 0; i <data.length ; i++) {
                t=JSON.parseObject(data[i],SensorDataRecord.class);
                t.setSensorType(sensor.getSensorType());
                t.setWarehouseId(sensor.getWarehouseId());
                t.setId(null);
                list.add(t);
            }
            sensorService.insertSensorDataRecord(list);
            return "ok";
        } catch (Exception e) {
            logger.error("上传监控数据失败" + e.getMessage());
            return "failed";
        }
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
