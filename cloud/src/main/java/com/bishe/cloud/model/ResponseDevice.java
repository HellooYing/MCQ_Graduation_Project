package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:响应外设
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 7:05 下午
 */
@Table(name = "response_device")
public class ResponseDevice {
    /**
     * 响应外设id
     */
    @Id
    private Long id;

    /**
     * 响应外设类型枚举编号
     */
    private Integer responseDeviceType;

    /**
     * 归属仓库id
     */
    private Long warehouseId;

    /**
     * 树莓派id
     */
    private Long piId;

   /**
     * 响应外设坐标
     */
    private String location;

    /**
     * 扩展字段
     */
    private String extension;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResponseDeviceType() {
        return responseDeviceType;
    }

    public void setResponseDeviceType(Integer responseDeviceType) {
        this.responseDeviceType = responseDeviceType;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getPiId() {
        return piId;
    }

    public void setPiId(Long piId) {
        this.piId = piId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ResponseDevice(Integer responseDeviceType, Long warehouseId, Long piId, String location) {
        this.responseDeviceType = responseDeviceType;
        this.warehouseId = warehouseId;
        this.piId = piId;
        this.location = location;
    }

    public ResponseDevice() {
    }

    public ResponseDevice(Long id) {
        this.id = id;
    }

    public ResponseDevice(Long id, Integer responseDeviceType, Long warehouseId, Long piId, String location) {
        this.id = id;
        this.responseDeviceType = responseDeviceType;
        this.warehouseId = warehouseId;
        this.piId = piId;
        this.location = location;
    }

    @Override
    public String toString() {
        return "ResponseDevice{" +
                "id=" + id +
                ", responseDeviceType=" + responseDeviceType +
                ", warehouseId=" + warehouseId +
                ", piId=" + piId +
                ", location='" + location + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
