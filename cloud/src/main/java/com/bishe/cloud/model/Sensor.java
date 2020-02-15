package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 传感器
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 6:52 下午
 */
@Table(name = "sensor")
public class Sensor {
    /**
     * 传感器id
     */
    @Id
    private Long id;

    /**
     * 传感器类型枚举编号
     */
    private Integer sensorType;

    /**
     * 归属仓库id
     */
    private Long warehouseId;

    /**
     * 树莓派id
     */
    private Long piId;

    /**
     * 传感器坐标
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

    public Integer getSensorType() {
        return sensorType;
    }

    public void setSensorType(Integer sensorType) {
        this.sensorType = sensorType;
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

    public Sensor(Integer sensorType, Long warehouseId, Long piId, String location) {
        this.sensorType = sensorType;
        this.warehouseId = warehouseId;
        this.piId = piId;
        this.location = location;
    }

    public Sensor() {
    }

    public Sensor(Long id, Integer sensorType, Long warehouseId, Long piId, String location) {
        this.id = id;
        this.sensorType = sensorType;
        this.warehouseId = warehouseId;
        this.piId = piId;
        this.location = location;
    }

    public Sensor(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", sensorType=" + sensorType +
                ", warehouseId=" + warehouseId +
                ", piId=" + piId +
                ", location='" + location + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
