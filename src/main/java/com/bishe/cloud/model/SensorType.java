package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 传感器类型
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 6:48 下午
 */
@Table(name = "sensor_type")
public class SensorType {
    /**
     * 传感器类型枚举编号
     */
    @Id
    private Integer sensorType;

    /**
     * 传感器名
     */
    private String name;

    /**
     * 传感器测量数值类型：
     * 0 布尔类型 如是否存在火焰，
     * 1 数值类型 如温度
     */
    private Integer valueType;

    /**
     * 扩展字段
     */
    private String extension;

    public SensorType() {
    }

    @Override
    public String toString() {
        return "SensorType{" +
                "sensorType=" + sensorType +
                ", name='" + name + '\'' +
                ", valueType=" + valueType +
                ", extension='" + extension + '\'' +
                '}';
    }

    public Integer getSensorType() {
        return sensorType;
    }

    public void setSensorType(Integer sensorType) {
        this.sensorType = sensorType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValueType() {
        return valueType;
    }

    public void setValueType(Integer valueType) {
        this.valueType = valueType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public SensorType(String name, Integer valueType) {
        this.name = name;
        this.valueType = valueType;
    }

    public SensorType(Integer sensorType) {
        this.sensorType = sensorType;
    }

    public SensorType(String name) {
        this.name = name;
    }

    public SensorType(Integer sensorType, String name, Integer valueType) {
        this.sensorType = sensorType;
        this.name = name;
        this.valueType = valueType;
    }
}
