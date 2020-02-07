package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 边缘设备
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 7:24 下午
 */
@Table(name = "pi")
public class Pi {
    /**
     * 派id
     */
    @Id
    private Long id;

    /**
     * 归属仓库id
     */
    private Long warehouse_id;

    /**
     * 树莓派坐标
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

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
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

    public Pi() {
    }

    public Pi(Long warehouse_id, String location) {
        this.warehouse_id = warehouse_id;
        this.location = location;
    }

    public Pi(Long id, Long warehouse_id, String location, String extension) {
        this.id = id;
        this.warehouse_id = warehouse_id;
        this.location = location;
        this.extension = extension;
    }
}
