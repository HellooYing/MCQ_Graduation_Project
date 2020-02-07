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
    private Integer authority_type;

    /**
     * 权限名称
     */
    private String name;

    public Integer getAuthority_type() {
        return authority_type;
    }

    public void setAuthority_type(Integer authority_type) {
        this.authority_type = authority_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorityType() {
    }

    public AuthorityType(Integer authority_type, String name) {
        this.authority_type = authority_type;
        this.name = name;
    }
}
