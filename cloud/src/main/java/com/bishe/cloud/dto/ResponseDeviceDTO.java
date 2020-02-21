package com.bishe.cloud.dto;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/17
 * @time: 5:42 下午
 */
public class ResponseDeviceDTO {
    /**
     * 响应外设id
     */
    private Long id;

    /**
     * 响应外设类型名
     */
    private Integer responseDeviceName;

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

    public Integer getResponseDeviceName() {
        return responseDeviceName;
    }

    public void setResponseDeviceName(Integer responseDeviceName) {
        this.responseDeviceName = responseDeviceName;
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
