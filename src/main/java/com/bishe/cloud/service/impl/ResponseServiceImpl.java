package com.bishe.cloud.service.impl;

import com.bishe.cloud.dao.ResponseDeviceDAO;
import com.bishe.cloud.dao.ResponseDeviceTypeDAO;
import com.bishe.cloud.dao.ResponseRecordDAO;
import com.bishe.cloud.model.ResponseDevice;
import com.bishe.cloud.model.ResponseDeviceType;
import com.bishe.cloud.model.ResponseRecord;
import com.bishe.cloud.service.ResponseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/10
 * @time: 5:07 下午
 */
@Service
public class ResponseServiceImpl implements ResponseService {
    @Resource
    ResponseDeviceDAO responseDeviceDAO;
    @Resource
    ResponseDeviceTypeDAO responseDeviceTypeDAO;
    @Resource
    ResponseRecordDAO responseRecordDAO;


    @Override
    public int deleteResponseRecord(long id) {
        return responseRecordDAO.deleteByPrimaryKey(new ResponseDevice(id));
    }

    @Override
    public int addResponseRecord(ResponseRecord responseRecord) {
        return responseRecordDAO.insertSelective(responseRecord);
    }

    @Override
    public int deleteResponseDevice(long id) {
        return responseDeviceDAO.deleteByExample(new ResponseDevice(id));
    }

    @Override
    public int updateResponseDeviceById(ResponseDevice responseDevice) {
        return responseDeviceDAO.updateByPrimaryKeySelective(responseDevice);
    }

    @Override
    public int addResponseDevice(ResponseDevice responseDevice) {
        return responseDeviceDAO.insertSelective(responseDevice);
    }

    @Override
    public ResponseDevice getResponseDevice(long id) {
        return responseDeviceDAO.selectByPrimaryKey(new ResponseDevice(id));
    }

    @Override
    public ResponseDeviceType getResponseDeviceType(int responseDeviceType) {
        return responseDeviceTypeDAO.selectByPrimaryKey(new ResponseDeviceType(responseDeviceType));
    }

    @Override
    public List<ResponseDeviceType> getResponseDeviceTypeByName(String name) {
        return responseDeviceTypeDAO.select(new ResponseDeviceType(name));
    }

    @Override
    public int addResponseDeviceType(ResponseDeviceType responseDeviceType) {
        return responseDeviceTypeDAO.insertSelective(responseDeviceType);
    }

    @Override
    public int deleteResponseDeviceType(int responseDeviceType) {
        return responseDeviceTypeDAO.deleteByPrimaryKey(responseDeviceType);
    }

    @Override
    public int renameResponseDeviceType(int responseDeviceType, String name) {
        return responseDeviceTypeDAO.updateByPrimaryKeySelective(new ResponseDeviceType(responseDeviceType,name));
    }
}
