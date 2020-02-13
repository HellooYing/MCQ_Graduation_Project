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
    private Integer responseDeviceType;

    /**
     * 响应外设名
     */
    private String name;

    /**
     * 扩展字段
     */
    private String extension;

    @Override
    public String toString() {
        return "ResponseDeviceType{" +
                "responseDeviceType=" + responseDeviceType +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }

    public Integer getResponseDeviceType() {
        return responseDeviceType;
    }

    public void setResponseDeviceType(Integer responseDeviceType) {
        this.responseDeviceType = responseDeviceType;
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

    public ResponseDeviceType(Integer responseDeviceType, String name) {
        this.responseDeviceType = responseDeviceType;
        this.name = name;
    }

    public ResponseDeviceType(Integer responseDeviceType, String name, String extension) {
        this.responseDeviceType = responseDeviceType;
        this.name = name;
        this.extension = extension;
    }

    public ResponseDeviceType() {
    }

    public ResponseDeviceType(Integer responseDeviceType) {
        this.responseDeviceType = responseDeviceType;
    }
}
