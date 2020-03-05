package com.bishe.cloud.service;

import com.bishe.cloud.model.Sensor;
import com.bishe.cloud.model.SensorDataRecord;
import com.bishe.cloud.model.SensorType;

import java.util.List;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/10
 * @time: 5:19 下午
 */
public interface SensorService {
    // 传感器类型增删改查
    int addSensorType(SensorType sensorType);

    int deleteSensorType(int sensorType);

    int updateSensorType(SensorType sensorType);

    SensorType getSensorType(int sensorType);

    //传感器增删改查
    int addSensor(Sensor sensor);

    int deleteSensor(long id);

    int updateSensorById(Sensor sensor);

    Sensor getSensor(long id);

    //传感器记录增删改查
    int addSensorDataRecord(SensorDataRecord sensorDataRecord);

    int deleteSensorDataRecord(long id);

    int updateSensorDataRecordById(SensorDataRecord sensorDataRecord);

    SensorDataRecord getSensorDataRecord(long id);

    List<SensorType> getAllType();

    List<Sensor> getAllSensor();

    List<SensorDataRecord> getAllRecord();

    SensorType getSensorTypeByName(String name);

    int insertSensorDataRecord(List<SensorDataRecord> list);
}
