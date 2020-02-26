package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:响应记录
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 7:10 下午
 */
@Table(name = "response_record")
public class ResponseRecord {
    @Id
    private Long id;

    /**
     * 仓库id（在哪个仓库响应）
     */
    private Long warehouseId;

    /**
     * 响应外设类型：
     * 0 继电器，
     * 1 蜂鸣器，
     * 2 信号灯
     */
    private Integer responseDeviceType;

    /**
     * 设备id
     */
    private Long responseDeviceId;

    /**
     * 响应时间
     */
    private Date createTime;

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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getResponseDeviceType() {
        return responseDeviceType;
    }

    public void setResponseDeviceType(Integer responseDeviceType) {
        this.responseDeviceType = responseDeviceType;
    }

    public Long getResponseDeviceId() {
        return responseDeviceId;
    }

    public void setResponseDeviceId(Long responseDeviceId) {
        this.responseDeviceId = responseDeviceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ResponseRecord() {
    }

    public ResponseRecord(Long id) {
        this.id = id;
    }

    public ResponseRecord(Long warehouseId, Integer responseDeviceType, Long responseDeviceId) {
        this.warehouseId = warehouseId;
        this.responseDeviceType = responseDeviceType;
        this.responseDeviceId = responseDeviceId;
    }

    public ResponseRecord(Long id, Long warehouseId, Integer responseDeviceType, Long responseDeviceId, String extension) {
        this.id = id;
        this.warehouseId = warehouseId;
        this.responseDeviceType = responseDeviceType;
        this.responseDeviceId = responseDeviceId;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "ResponseRecord{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", responseDeviceType=" + responseDeviceType +
                ", responseDeviceId=" + responseDeviceId +
                ", createTime=" + createTime +
                ", extension='" + extension + '\'' +
                '}';
    }
}
