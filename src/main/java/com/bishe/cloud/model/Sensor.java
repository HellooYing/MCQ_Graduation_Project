package com.bishe.cloud.model;

/**
 * @description: 传感器
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 6:52 下午
 */
public class Sensor {
    /**
     * 传感器id
     */
    private Long id;

    /**
     * 传感器类型枚举编号
     */
    private Integer sensor_type;

    /**
     * 归属仓库id
     */
    private Long warehouse_id;

    /**
     * 树莓派id
     */
    private Long pi_id;

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

    public Integer getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(Integer sensor_type) {
        this.sensor_type = sensor_type;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Long getPi_id() {
        return pi_id;
    }

    public void setPi_id(Long pi_id) {
        this.pi_id = pi_id;
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

    public Sensor(Integer sensor_type, Long warehouse_id, Long pi_id, String location) {
        this.sensor_type = sensor_type;
        this.warehouse_id = warehouse_id;
        this.pi_id = pi_id;
        this.location = location;
    }

    public Sensor() {
    }

    public Sensor(Integer sensor_type, Long warehouse_id, Long pi_id, String location, String extension) {
        this.sensor_type = sensor_type;
        this.warehouse_id = warehouse_id;
        this.pi_id = pi_id;
        this.location = location;
        this.extension = extension;
    }
}
