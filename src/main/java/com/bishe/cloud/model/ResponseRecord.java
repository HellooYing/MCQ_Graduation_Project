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
    private Long warehouse_id;

    /**
     * 响应外设类型：
     * 0 继电器，
     * 1 蜂鸣器，
     * 2 信号灯
     */
    private Integer response_device_type;

    /**
     * 设备id
     */
    private Long response_device_id;

    /**
     * 响应时间
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

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Integer getResponse_device_type() {
        return response_device_type;
    }

    public void setResponse_device_type(Integer response_device_type) {
        this.response_device_type = response_device_type;
    }

    public Long getResponse_device_id() {
        return response_device_id;
    }

    public void setResponse_device_id(Long response_device_id) {
        this.response_device_id = response_device_id;
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

    public ResponseRecord() {
    }

    public ResponseRecord(Long warehouse_id, Integer response_device_type, Long response_device_id, Date create_time) {
        this.warehouse_id = warehouse_id;
        this.response_device_type = response_device_type;
        this.response_device_id = response_device_id;
        this.create_time = create_time;
    }

    public ResponseRecord(Long id, Long warehouse_id, Integer response_device_type, Long response_device_id, Date create_time, String extension) {
        this.id = id;
        this.warehouse_id = warehouse_id;
        this.response_device_type = response_device_type;
        this.response_device_id = response_device_id;
        this.create_time = create_time;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "ResponseRecord{" +
                "id=" + id +
                ", warehouse_id=" + warehouse_id +
                ", response_device_type=" + response_device_type +
                ", response_device_id=" + response_device_id +
                ", create_time=" + create_time +
                ", extension='" + extension + '\'' +
                '}';
    }
}
