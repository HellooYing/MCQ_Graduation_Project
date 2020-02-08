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
    private Integer sensor_type;

    /**
     * 传感器名
     */
    private String name;

    /**
     * 传感器测量数值类型：
     * 0 布尔类型 如是否存在火焰，
     * 1 数值类型 如温度
     */
    private Integer value_type;

    /**
     * 扩展字段
     */
    private String extension;

    public SensorType() {
    }

    public SensorType(Integer sensor_type, String name, Integer value_type, String extension) {
        this.sensor_type = sensor_type;
        this.name = name;
        this.value_type = value_type;
        this.extension = extension;
    }

    public SensorType(String name, Integer value_type) {
        this.name = name;
        this.value_type = value_type;
    }

    public Integer getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(Integer sensor_type) {
        this.sensor_type = sensor_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue_type() {
        return value_type;
    }

    public void setValue_type(Integer value_type) {
        this.value_type = value_type;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "SensorType{" +
                "sensor_type=" + sensor_type +
                ", name='" + name + '\'' +
                ", value_type=" + value_type +
                ", extension='" + extension + '\'' +
                '}';
    }
}
