package com.bishe.cloud.service;

import com.bishe.cloud.model.ResponseDevice;
import com.bishe.cloud.model.ResponseDeviceType;
import com.bishe.cloud.model.ResponseRecord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 响应外设服务
 * @author: mayingying03
 * @date: 2020/2/8
 * @time: 7:39 下午
 */
public interface ResponseService {
    /**
     * 删除响应记录
     * @param id
     * @return
     */
    int deleteResponseRecord(long id);

    /**
     * 添加响应记录
     * @param responseRecord
     * @return
     */
    int addResponseRecord(ResponseRecord responseRecord);

    /**
     * 删除响应外设
     * @param id
     * @return
     */
    int deleteResponseDevice(long id);

    /**
     * 根据主键修改响应外设信息（只填写需修改的字段及主键，其余字段空）
     * @param responseDevice
     * @return
     */
    int updateResponseDeviceById(ResponseDevice responseDevice);

    /**
     * 添加响应外设
     * @param responseDevice
     * @return
     */
    int addResponseDevice(ResponseDevice responseDevice);

    /**
     * 根据id查找响应外设
     * @param id
     * @return
     */
    ResponseDevice getResponseDevice(long id);

    /**
     * 根据响应外设类型枚举编号查找响应外设类型
     * @param responseDeviceType 响应外设类型枚举编号
     * @return 响应外设类型
     */
    ResponseDeviceType getResponseDeviceType(int responseDeviceType);

    /**
     * 根据响应外设类型名查找响应外设类型
     * @param name
     * @return
     */
    ResponseDeviceType getResponseDeviceTypeByName(String name);

    /**
     * 添加响应外设类型
     * @param responseDeviceType
     * @return 是否成功
     */
    int addResponseDeviceType(ResponseDeviceType responseDeviceType);

    /**
     * 删除响应外设类型
     * @param responseDeviceType
     * @return
     */
    int deleteResponseDeviceType(int responseDeviceType);

    /**
     * 修改响应外设类型名
     * @param responseDeviceType
     * @param name
     * @return
     */
    int renameResponseDeviceType(int responseDeviceType,String name);

    List<ResponseDeviceType> getAllType();

    List<ResponseDevice> getAllDevice();

    List<ResponseRecord> getAllRecord();
}
