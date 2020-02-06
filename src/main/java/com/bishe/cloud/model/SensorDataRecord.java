package com.bishe.cloud.model;

import java.util.Date;

/**
 * @description:传感器监控数据记录
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 6:56 下午
 */
public class SensorDataRecord {
    private Long id;

    /**
     * 仓库id（在哪个仓库测量的记录）
     */
    private Long warehouse_id;

    /**
     * 传感器类型：
     * 0 火焰，
     * 1 雨滴，
     * 2 温度，
     * 3 湿度，
     * 4 光照，
     * 5 声音，
     * 6 烟雾
     */
    private Integer sensor_type;

    /**
     * 传感器id
     */
    private Long sensor_id;

    /**
     * 记录值
     */
    private String value;

    /**
     * 记录时间
     */
    private Date create_time;

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

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Integer getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(Integer sensor_type) {
        this.sensor_type = sensor_type;
    }

    public Long getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Long sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public SensorDataRecord(Long warehouse_id, Integer sensor_type, Long sensor_id, String value, Date create_time) {
        this.warehouse_id = warehouse_id;
        this.sensor_type = sensor_type;
        this.sensor_id = sensor_id;
        this.value = value;
        this.create_time = create_time;
    }

    public SensorDataRecord() {
    }

    public SensorDataRecord(Long warehouse_id, Integer sensor_type, Long sensor_id, String value, Date create_time, String extension) {
        this.warehouse_id = warehouse_id;
        this.sensor_type = sensor_type;
        this.sensor_id = sensor_id;
        this.value = value;
        this.create_time = create_time;
        this.extension = extension;
    }

    public SensorDataRecord(Long id, Long warehouse_id, Integer sensor_type, Long sensor_id, String value, Date create_time, String extension) {
        this.id = id;
        this.warehouse_id = warehouse_id;
        this.sensor_type = sensor_type;
        this.sensor_id = sensor_id;
        this.value = value;
        this.create_time = create_time;
        this.extension = extension;
    }
}
