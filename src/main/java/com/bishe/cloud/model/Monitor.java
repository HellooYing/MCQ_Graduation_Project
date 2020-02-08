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
    private Long sensor_id;

    /**
     * 响应设备列表
     */
    private String response_device_list;

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
    private Date create_time;

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

    public Long getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Long sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getResponse_device_list() {
        return response_device_list;
    }

    public void setResponse_device_list(String response_device_list) {
        this.response_device_list = response_device_list;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Monitor(Long sensor_id, String response_device_list, String time, String emails, Integer sync_num, Date create_time) {
        this.sensor_id = sensor_id;
        this.response_device_list = response_device_list;
        this.time = time;
        this.emails = emails;
        this.sync_num = sync_num;
        this.create_time = create_time;
    }

    public Monitor() {
    }

    public Monitor(Long id, Long sensor_id, String response_device_list, String time, String emails, Integer sync_num, Boolean using, Date create_time, String extension) {
        this.id = id;
        this.sensor_id = sensor_id;
        this.response_device_list = response_device_list;
        this.time = time;
        this.emails = emails;
        this.sync_num = sync_num;
        this.using = using;
        this.create_time = create_time;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "id=" + id +
                ", sensor_id=" + sensor_id +
                ", response_device_list='" + response_device_list + '\'' +
                ", time='" + time + '\'' +
                ", emails='" + emails + '\'' +
                ", sync_num=" + sync_num +
                ", using=" + using +
                ", create_time=" + create_time +
                ", extension='" + extension + '\'' +
                '}';
    }
}
