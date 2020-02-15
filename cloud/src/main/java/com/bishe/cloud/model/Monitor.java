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
    private Integer sync_num;

    /**
     * 是否启用
     */
    private Boolean using;

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
                ", sync_num=" + sync_num +
                ", using=" + using +
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

    public Integer getSync_num() {
        return sync_num;
    }

    public void setSync_num(Integer sync_num) {
        this.sync_num = sync_num;
    }

    public Boolean getUsing() {
        return using;
    }

    public void setUsing(Boolean using) {
        this.using = using;
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

    public Monitor(Long id, Long sensorId, String responseDeviceList, String time, String emails, Integer sync_num) {
        this.id = id;
        this.sensorId = sensorId;
        this.responseDeviceList = responseDeviceList;
        this.time = time;
        this.emails = emails;
        this.sync_num = sync_num;
    }

    public Monitor(Long sensorId, String responseDeviceList, String time, String emails, Integer sync_num, Boolean using, Date createTime) {
        this.sensorId = sensorId;
        this.responseDeviceList = responseDeviceList;
        this.time = time;
        this.emails = emails;
        this.sync_num = sync_num;
        this.using = using;
        this.createTime = createTime;
    }

    public Monitor() {
    }

    public Monitor(Long id) {
        this.id = id;
    }

    public Monitor(Long id, Long sensorId, String responseDeviceList, String time, String emails, Integer sync_num, Boolean using, Date createTime, String extension) {
        this.id = id;
        this.sensorId = sensorId;
        this.responseDeviceList = responseDeviceList;
        this.time = time;
        this.emails = emails;
        this.sync_num = sync_num;
        this.using = using;
        this.createTime = createTime;
        this.extension = extension;
    }
}
