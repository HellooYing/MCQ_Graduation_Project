package com.bishe.cloud.service.impl;

import com.bishe.cloud.dao.SensorDAO;
import com.bishe.cloud.dao.SensorDataRecordDAO;
import com.bishe.cloud.dao.SensorTypeDAO;
import com.bishe.cloud.model.Monitor;
import com.bishe.cloud.model.Sensor;
import com.bishe.cloud.model.SensorDataRecord;
import com.bishe.cloud.model.SensorType;
import com.bishe.cloud.service.SensorService;
import com.bishe.cloud.util.CloudUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 传感器相关服务
 * @author: mayingying03
 * @date: 2020/2/10
 * @time: 5:44 下午
 */
@Service
public class SensorServiceImpl implements SensorService{
    @Resource
    SensorDAO sensorDAO;
    @Resource
    SensorTypeDAO sensorTypeDAO;
    @Resource
    SensorDataRecordDAO sensorDataRecordDAO;

    @Override
    public int addSensorType(SensorType sensorType) {
        return sensorTypeDAO.insertSelective(sensorType);
    }

    @Override
    public int deleteSensorType(int sensorType) {
        return sensorTypeDAO.deleteByPrimaryKey(new SensorType(sensorType));
    }

    @Override
    public int updateSensorType(SensorType sensorType) {
        return sensorTypeDAO.updateByPrimaryKeySelective(sensorType);
    }

    @Override
    public SensorType getSensorType(int sensorType) {
        return sensorTypeDAO.selectByPrimaryKey(new SensorType(sensorType));
    }

    @Override
    public int addSensor(Sensor sensor) {
        return sensorDAO.insertSelective(sensor);
    }

    @Override
    public int deleteSensor(long id) {
        return sensorDAO.deleteByPrimaryKey(new Sensor(id));
    }

    @Override
    public int updateSensorById(Sensor sensor) {
        return sensorDAO.updateByPrimaryKeySelective(sensor);
    }

    @Override
    public Sensor getSensor(long id) {
        return sensorDAO.selectByPrimaryKey(new Sensor(id));
    }

    @Override
    public int addSensorDataRecord(SensorDataRecord sensorDataRecord) {
        return sensorDataRecordDAO.insertSelective(sensorDataRecord);
    }

    @Override
    public int deleteSensorDataRecord(long id) {
        return sensorDataRecordDAO.deleteByPrimaryKey(new SensorDataRecord(id));
    }

    @Override
    public int updateSensorDataRecordById(SensorDataRecord sensorDataRecord) {
        return sensorDataRecordDAO.updateByPrimaryKeySelective(sensorDataRecord);
    }

    @Override
    public SensorDataRecord getSensorDataRecord(long id) {
        return sensorDataRecordDAO.selectByPrimaryKey(new SensorDataRecord(id));
    }

    @Override
    public List<SensorType> getAllType() {
        return sensorTypeDAO.selectAll();
    }

    @Override
    public List<Sensor> getAllSensor() {
        return sensorDAO.selectAll();
    }

    @Override
    public List<SensorDataRecord> getAllRecord() {
        return sensorDataRecordDAO.selectAll();
    }



    @Override
    public SensorType getSensorTypeByName(String name) {
        List<SensorType> list = sensorTypeDAO.select(new SensorType(name));
        if(list.size()==0) return null;
        else return list.get(0);
    }

    @Override
    public int insertSensorDataRecord(List<SensorDataRecord> list) {
        return sensorDataRecordDAO.insertList(list);
    }

    @Override
    public String doSensor(Long id) {
        Map<String,String> map=new HashMap<>();
        map.put("id",id.toString());
        String result = CloudUtil.sendPost("http://"+getUrl(id) + "/doSensor", map);
        if (result.equals("failed")) {
            return "";
        } else {
            return result;
        }
    }

    @Override
    public String getUrl(Long id) {
        return sensorDAO.getUrl(id)+":8000";
    }
}
