package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:传感器监控数据记录
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 6:56 下午
 */
@Table(name = "sensor_data_record")
public class SensorDataRecord {
    @Id
    private Long id;

    /**
     * 仓库id（在哪个仓库测量的记录）
     */
    private Long warehouseId;

    /**
     * 传感器类型：
     * 0 火焰，
     * 1 雨滴，
     * 2 温度，
     * 3 湿度，
     * 4 光照，
     * 5 声音，
     * 6 烟雾
     */
    private Integer sensorType;

    /**
     * 传感器id
     */
    private Long sensorId;

    /**
     * 记录值
     */
    private String value;

    /**
     * 记录时间
     */
    private Date createTime;

    /**
     * 扩展字段
     */
    private String extension;

    @Override
    public String toString() {
        return "SensorDataRecord{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", sensorType=" + sensorType +
                ", sensorId=" + sensorId +
                ", value='" + value + '\'' +
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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getSensorType() {
        return sensorType;
    }

    public void setSensorType(Integer sensorType) {
        this.sensorType = sensorType;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public SensorDataRecord(Long warehouseId, Integer sensorType, Long sensorId, String value, Date createTime) {
        this.warehouseId = warehouseId;
        this.sensorType = sensorType;
        this.sensorId = sensorId;
        this.value = value;
        this.createTime = createTime;
    }

    public SensorDataRecord() {
    }

    public SensorDataRecord(Long id) {
        this.id = id;
    }

    public SensorDataRecord(Long id, Long warehouseId, Integer sensorType, Long sensorId, String value, Date createTime, String extension) {
        this.id = id;
        this.warehouseId = warehouseId;
        this.sensorType = sensorType;
        this.sensorId = sensorId;
        this.value = value;
        this.createTime = createTime;
        this.extension = extension;
    }
}
