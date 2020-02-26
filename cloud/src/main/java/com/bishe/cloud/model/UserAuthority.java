package com.bishe.cloud.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:用户权限
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 7:28 下午
 */
@Table(name = "user_authority")
public class UserAuthority {
    @Id
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 权限类型
     */
    private Integer authorityType;

    @Override
    public String toString() {
        return "UserAuthority{" +
                "id=" + id +
                ", userId=" + userId +
                ", authorityType=" + authorityType +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAuthorityType() {
        return authorityType;
    }

    public void setAuthorityType(Integer authorityType) {
        this.authorityType = authorityType;
    }

    public UserAuthority(Long userId, Integer authorityType) {
        this.userId = userId;
        this.authorityType = authorityType;
    }

    public UserAuthority() {
    }

    public UserAuthority(Long id) {
        this.id = id;
    }

    public UserAuthority(Long id, Long userId, Integer authorityType) {
        this.id = id;
        this.userId = userId;
        this.authorityType = authorityType;
    }
}
