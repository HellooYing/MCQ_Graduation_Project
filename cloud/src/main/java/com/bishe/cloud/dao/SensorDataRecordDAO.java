package com.bishe.cloud.dao;

import com.bishe.cloud.model.SensorDataRecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 9:22 下午
 */
public interface SensorDataRecordDAO extends Mapper<SensorDataRecord> {
    int insertList(List<SensorDataRecord> list);
}
