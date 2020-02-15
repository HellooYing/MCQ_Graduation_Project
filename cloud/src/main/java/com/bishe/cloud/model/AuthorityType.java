package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:权限枚举
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 7:26 下午
 */
@Table(name="authority_type")
public class AuthorityType {
    /**
     * 权限类型枚举编号
     */
    @Id
    private Integer authorityType;

    /**
     * 权限名称
     */
    private String name;

    public AuthorityType(Integer authorityType, String name) {
        this.authorityType = authorityType;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorityType{" +
                "authorityType=" + authorityType +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getauthorityType() {
        return authorityType;
    }

    public void setauthorityType(Integer authorityType) {
        this.authorityType = authorityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorityType() {
    }

    public AuthorityType(Integer authorityType) {
        this.authorityType = authorityType;
    }
}
