package com.bishe.cloud.service;

import com.bishe.cloud.model.Monitor;

import java.util.List;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/10
 * @time: 6:37 下午
 */
public interface MonitorService {
    int addMonitor(Monitor monitor);

    int updateMonitor(Monitor monitor);

    int deleteMonitor(long id);

    Monitor getMonitor(long id);

    List<Monitor> getAll();
}
