package com.bishe.cloud.controller;

import com.bishe.cloud.model.*;
import com.bishe.cloud.service.PiService;
import com.bishe.cloud.service.ResponseService;
import com.bishe.cloud.service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 设备管理
 * @author: mayingying03
 * @date: 2020/2/13
 * @time: 11:16 上午
 */
@Controller
public class DeviceController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);
    @Resource
    ResponseService responseService;
    @Resource
    PiService piService;
    @Resource
    SensorService sensorService;

    @RequestMapping(path = {"/getSensorTypeId"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getSensorTypeId(@RequestParam("name") String name) {
        try {
            List<SensorType> list = sensorService.getSensorTypeByName(name);
            if(list.size()==0){
                return "not found";
            }
            return list.get(0).getId().toString();
        } catch (Exception e) {
            logger.error("根据传感器类型名查找类型id错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/getSensorTypeName"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getSensorTypeName(@RequestParam("id") int id) {
        try {
            SensorType sensorType = sensorService.getSensorType(id);
            if(sensorType==null){
                return "not found";
            }
            return sensorType.getName();
        } catch (Exception e) {
            logger.error("根据响应外设类型id查找类型名错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/getResponseDeviceTypeId"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getResponseDeviceTypeId(@RequestParam("name") String name) {
        try {
            List<ResponseDeviceType> list = responseService.getResponseDeviceTypeByName(name);
            if(list.size()==0){
                return "not found";
            }
            return list.get(0).getId().toString();
        } catch (Exception e) {
            logger.error("根据响应外设类型名查找类型id错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/getResponseDeviceTypeName"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getResponseDeviceTypeName(@RequestParam("id") int id) {
        try {
            ResponseDeviceType responseDeviceType = responseService.getResponseDeviceType(id);
            if(responseDeviceType==null){
                return "not found";
            }
            return responseDeviceType.getName();
        } catch (Exception e) {
            logger.error("根据响应外设类型id查找类型名错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/sensor"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String sensor(Model model) {
        try {
            model.addAttribute("sensors",sensorService.getAllSensor());
        } catch (Exception e) {
            logger.error("显示全部传感器信息错误" + e.getMessage());
        }
        return "home";
    }

    @RequestMapping(path = {"/sensorType"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String sensorType(Model model) {
        try {
            model.addAttribute("sensorTypes",sensorService.getAllType());
        } catch (Exception e) {
            logger.error("显示全部传感器类型信息错误" + e.getMessage());
        }
        return "home";
    }

    @RequestMapping(path = {"/responseDevice"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String responseDevice(Model model) {
        try {
            model.addAttribute("responseDevices",responseService.getAllDevice());
        } catch (Exception e) {
            logger.error("显示全部响应外设信息错误" + e.getMessage());
        }
        return "home";
    }

    @RequestMapping(path = {"/responseDeviceType"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String responseDeviceType(Model model) {
        try {
            model.addAttribute("responseDeviceTypes",responseService.getAllType());
        } catch (Exception e) {
            logger.error("显示全部响应外设类型信息错误" + e.getMessage());
        }
        return "home";
    }

    @RequestMapping(path = {"/pi"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String pi(Model model) {
        try {
            //TODO 权限验证，暂时不写
            model.addAttribute("pis",piService.getAll());
        } catch (Exception e) {
            logger.error("显示全部边缘设备信息错误" + e.getMessage());
        }
        return "home";
    }

    @RequestMapping(path = {"/addPi"}, method = {RequestMethod.POST})
    @ResponseBody
    public String addPi(@RequestParam("warehouseId") long warehouseId,
                        @RequestParam("location") String location,
                        @RequestParam("url") String url) {
        try {
            Pi pi = new Pi(warehouseId, location, url);
            piService.addPi(pi);
            return String.valueOf(pi.getId());
        } catch (Exception e) {
            logger.error("添加边缘设备错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/addSensor"}, method = {RequestMethod.POST})
    @ResponseBody
    public String addSensor(@RequestParam("sensorType") int sensorType,
                            @RequestParam("warehouseId") long warehouseId,
                            @RequestParam("piId") long piId,
                            @RequestParam("location") String location) {
        try {
            Sensor sensor=new Sensor(sensorType, warehouseId, piId, location);
            sensorService.addSensor(sensor);
            return String.valueOf(sensor.getId());
        } catch (Exception e) {
            logger.error("添加传感器错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/addSensorType"}, method = {RequestMethod.POST})
    public String addSensorType(@RequestParam("name") String name) {
        try {
            sensorService.addSensorType(new SensorType(name));
        } catch (Exception e) {
            logger.error("添加传感器类型错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/addResponseDevice"}, method = {RequestMethod.POST})
    @ResponseBody
    public String addResponseDevice(@RequestParam("responseDeviceType") int responseDeviceType,
                                    @RequestParam("warehouseId") long warehouseId,
                                    @RequestParam("piId") long piId,
                                    @RequestParam("location") String location) {
        try {
            ResponseDevice responseDevice=new ResponseDevice(responseDeviceType, warehouseId, piId, location);
            responseService.addResponseDevice(responseDevice);
            return String.valueOf(responseDevice.getId());
        } catch (Exception e) {
            logger.error("添加响应外设错误" + e.getMessage());
            return "failed";
        }
    }

    @RequestMapping(path = {"/addResponseDeviceType"}, method = {RequestMethod.POST})
    public String addResponseDeviceType(@RequestParam("name") String name) {
        try {
            responseService.addResponseDeviceType(new ResponseDeviceType(name));
        } catch (Exception e) {
            logger.error("添加响应外设类型错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/deletePi/{piId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String deletePi(@PathVariable("piId") long piId) {
        try {
            piService.deletePi(piId);
        } catch (Exception e) {
            logger.error("删除边缘设备错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/deleteSensor/{sensorId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteSensor(@PathVariable("sensorId") long sensorId) {
        try {
            sensorService.deleteSensor(sensorId);
        } catch (Exception e) {
            logger.error("删除传感器错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/deleteSensorType/{sensorType}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteSensorType(@PathVariable("sensorType") int sensorType) {
        try {
            sensorService.deleteSensorType(sensorType);
        } catch (Exception e) {
            logger.error("删除传感器类型错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/deleteResponseDevice"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteResponseDevice(@PathVariable("responseDeviceId") long responseDeviceId) {
        try {
            responseService.deleteResponseDevice(responseDeviceId);
        } catch (Exception e) {
            logger.error("删除响应外设错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/deleteResponseDeviceType"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteResponseDeviceType(@PathVariable("responseDeviceType") int responseDeviceType) {
        try {
            responseService.deleteResponseDeviceType(responseDeviceType);
        } catch (Exception e) {
            logger.error("删除响应外设类型错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/updatePi"}, method = {RequestMethod.POST})
    public String updatePi(@RequestParam("piId") long piId,
                           @RequestParam("warehouseId") long warehouseId,
                           @RequestParam("location") String location) {
        try {
            piService.updatePi(new Pi(piId, warehouseId, location));
        } catch (Exception e) {
            logger.error("更新边缘设备错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/updateSensor"}, method = {RequestMethod.POST})
    public String updateSensor(@RequestParam("sensorId") long sensorId,
                               @RequestParam("sensorType") int sensorType,
                               @RequestParam("warehouseId") long warehouseId,
                               @RequestParam("piId") long piId,
                               @RequestParam("location") String location) {
        try {
            sensorService.updateSensorById(new Sensor(sensorId, sensorType, warehouseId, piId, location));
        } catch (Exception e) {
            logger.error("更新传感器错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/updateSensorType"}, method = {RequestMethod.POST})
    public String updateSensorType(@RequestParam("sensorType") int sensorType,
                                   @RequestParam("name") String name,
                                   @RequestParam("valueType") int valueType) {
        try {
            sensorService.updateSensorType(new SensorType(sensorType, name, valueType));
        } catch (Exception e) {
            logger.error("更新传感器类型错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/updateResponseDevice"}, method = {RequestMethod.POST})
    public String updateResponseDevice(@RequestParam("responseDeviceId") long responseDeviceId,
                                       @RequestParam("responseDeviceType") int responseDeviceType,
                                       @RequestParam("warehouseId") long warehouseId,
                                       @RequestParam("piId") long piId,
                                       @RequestParam("location") String location) {
        try {
            responseService.updateResponseDeviceById(new ResponseDevice(responseDeviceId,responseDeviceType, warehouseId, piId, location));
        } catch (Exception e) {
            logger.error("更新响应外设错误" + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(path = {"/updateResponseDeviceType"}, method = {RequestMethod.POST})
    public String updateResponseDeviceType(@RequestParam("deviceType") int deviceType,
                                           @RequestParam("name") String name) {
        try {
            responseService.renameResponseDeviceType(deviceType,name);
        } catch (Exception e) {
            logger.error("更新响应外设类型错误" + e.getMessage());
        }
        return "redirect:/home";
    }


}
