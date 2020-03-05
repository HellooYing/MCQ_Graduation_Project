package com.bishe.cloud.service.impl;

import com.bishe.cloud.common.ResultBase;
import com.bishe.cloud.dao.MonitorDAO;
import com.bishe.cloud.model.Monitor;
import com.bishe.cloud.service.MonitorService;
import com.bishe.cloud.util.CloudUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/13
 * @time: 10:27 上午
 */
@Service
public class MonitorServiceImpl implements MonitorService {
    @Resource
    MonitorDAO monitorDAO;
    @Resource
    MonitorService monitorService;

    @Override
    public int addMonitor(Monitor monitor) {
        return monitorDAO.insertSelective(monitor);
    }

    @Override
    public int updateMonitor(Monitor monitor) {
        return monitorDAO.updateByPrimaryKeySelective(monitor);
    }

    @Override
    public int deleteMonitor(long id) {
        return monitorDAO.deleteByPrimaryKey(new Monitor(id));
    }

    @Override
    public Monitor getMonitor(long id) {
        return monitorDAO.selectByPrimaryKey(new Monitor(id));
    }

    @Override
    public List<Monitor> getAll() {
        return monitorDAO.selectAll();
    }

    @Override
    public boolean doMonitor(Long id) {
        Map<String,String> map=new HashMap<>();
        map.put("id",id.toString());
        String result = CloudUtil.sendPost("http://"+monitorService.getUrl(id) + "/doMonitor", map);
        if (result.equals("ok")) {
            Monitor monitor=getMonitor(id);
            monitor.setIsUsing(true);
            updateMonitor(monitor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean undoMonitor(Long id) {
        Map<String,String> map=new HashMap<>();
        map.put("id",id.toString());
        String result = CloudUtil.sendPost("http://"+monitorService.getUrl(id) + "/undoMonitor", map);
        if (result.equals("ok")) {
            Monitor monitor=getMonitor(id);
            monitor.setIsUsing(false);
            updateMonitor(monitor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<String, String> toMap(Monitor monitor) {
        Map<String,String> map=new HashMap<>();
        map.put("id",monitor.getId().toString());
        map.put("sensorId",monitor.getSensorId().toString());
        map.put("responseDeviceList",monitor.getResponseDeviceList());
        map.put("time",monitor.getTime());
        map.put("emails",monitor.getEmails());
        map.put("sync_num",monitor.getSyncNum().toString());
        return map;
    }

    @Override
    public String getUrl(Long id) {
        return monitorDAO.getUrl(id);
    }
}
