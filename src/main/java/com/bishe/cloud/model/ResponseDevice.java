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
    private Integer response_device_type;

    /**
     * 归属仓库id
     */
    private Long warehouse_id;

    /**
     * 树莓派id
     */
    private Long pi_id;

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

    public Integer getResponse_device_type() {
        return response_device_type;
    }

    public void setResponse_device_type(Integer response_device_type) {
        this.response_device_type = response_device_type;
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

    public ResponseDevice(Integer response_device_type, Long warehouse_id, Long pi_id, String location) {
        this.response_device_type = response_device_type;
        this.warehouse_id = warehouse_id;
        this.pi_id = pi_id;
        this.location = location;
    }

    public ResponseDevice() {
    }

    public ResponseDevice(Long id, Integer response_device_type, Long warehouse_id, Long pi_id, String location, String extension) {
        this.id = id;
        this.response_device_type = response_device_type;
        this.warehouse_id = warehouse_id;
        this.pi_id = pi_id;
        this.location = location;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "ResponseDevice{" +
                "id=" + id +
                ", response_device_type=" + response_device_type +
                ", warehouse_id=" + warehouse_id +
                ", pi_id=" + pi_id +
                ", location='" + location + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
