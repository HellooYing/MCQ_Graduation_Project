package com.bishe.cloud.dto;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/17
 * @time: 8:22 下午
 */
public class MonitorDTO {
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
}
