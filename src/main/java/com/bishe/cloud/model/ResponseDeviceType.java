package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:响应外设类型枚举
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 7:02 下午
 */
@Table(name = "response_device_type")
public class ResponseDeviceType {
    /**
     * 响应外设类型枚举编号
     */
    @Id
    private Integer response_device_type;

    /**
     * 响应外设名
     */
    private String name;

    /**
     * 扩展字段
     */
    private String extension;

    public Integer getResponse_device_type() {
        return response_device_type;
    }

    public void setResponse_device_type(Integer response_device_type) {
        this.response_device_type = response_device_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ResponseDeviceType(String name) {
        this.name = name;
    }

    public ResponseDeviceType() {
    }

    public ResponseDeviceType(Integer response_device_type, String name, String extension) {
        this.response_device_type = response_device_type;
        this.name = name;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "ResponseDeviceType{" +
                "response_device_type=" + response_device_type +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
