package com.bishe.cloud.dto;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/17
 * @time: 6:13 下午
 */
public class SensorDTO {
    /**
     * 传感器id
     */
    private Long id;

    /**
     * 传感器类型名
     */
    private Integer sensorName;

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

    public Integer getSensorName() {
        return sensorName;
    }

    public void setSensorName(Integer sensorName) {
        this.sensorName = sensorName;
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
}
