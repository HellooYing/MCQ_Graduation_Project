package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 监控配置
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 7:17 下午
 */
@Table(name = "monitor")
public class Monitor {
    @Id
    private Long id;

    /**
     * 传感器id
     */
    private Long sensorId;

    /**
     * 响应设备列表
     */
    private String responseDeviceList;

    /**
     * 执行时间表达式
     */
    private String time;

    /**
     * 邮件通知组
     */
    private String emails;

    /**
     * 从边缘设备批量同步监控数据的条数
     */
    private Integer syncNum;

    /**
     * 是否启用
     */
    private Boolean isUsing;

    /**
     * 异常值、异常范围
     */
    private String abnormal;

    /**
     * 创建计划时间
     */
    private Date createTime;

    /**
     * 扩展字段
     */
    private String extension;

    @Override
    public String toString() {
        return "Monitor{" +
                "id=" + id +
                ", sensorId=" + sensorId +
                ", responseDeviceList='" + responseDeviceList + '\'' +
                ", time='" + time + '\'' +
                ", emails='" + emails + '\'' +
                ", sync_num=" + syncNum +
                ", using=" + isUsing +
                ", createTime=" + createTime +
                ", extension='" + extension + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getResponseDeviceList() {
        return responseDeviceList;
    }

    public void setResponseDeviceList(String responseDeviceList) {
        this.responseDeviceList = responseDeviceList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public Integer getSyncNum() {
        return syncNum;
    }

    public void setSyncNum(Integer syncNum) {
        this.syncNum = syncNum;
    }

    public Boolean getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(Boolean isUsing) {
        this.isUsing = isUsing;
    }

    public Boolean getUsing() {
        return isUsing;
    }

    public void setUsing(Boolean using) {
        isUsing = using;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
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

    public Monitor(Long id, Long sensorId, String responseDeviceList, String time, String emails, Integer syncNum,String abnormal) {
        this.id = id;
        this.sensorId = sensorId;
        this.responseDeviceList = responseDeviceList;
        this.time = time;
        this.emails = emails;
        this.syncNum = syncNum;
        this.abnormal=abnormal;
    }

    public Monitor(Long sensorId, String responseDeviceList, String time, String emails, Integer syncNum, Boolean isUsing,String abnormal) {
        this.sensorId = sensorId;
        this.responseDeviceList = responseDeviceList;
        this.time = time;
        this.emails = emails;
        this.syncNum = syncNum;
        this.isUsing = isUsing;
        this.abnormal=abnormal;
    }

    public Monitor() {
    }

    public Monitor(Long id) {
        this.id = id;
    }

    public Monitor(Long id, Long sensorId, String responseDeviceList, String time, String emails, Integer syncNum, Boolean isUsing, String extension) {
        this.id = id;
        this.sensorId = sensorId;
        this.responseDeviceList = responseDeviceList;
        this.time = time;
        this.emails = emails;
        this.syncNum = syncNum;
        this.isUsing = isUsing;
        this.extension = extension;
    }
}
