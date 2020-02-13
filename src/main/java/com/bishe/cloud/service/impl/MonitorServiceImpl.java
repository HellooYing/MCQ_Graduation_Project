package com.bishe.cloud.service.impl;

import com.bishe.cloud.dao.MonitorDAO;
import com.bishe.cloud.model.Monitor;
import com.bishe.cloud.service.MonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
