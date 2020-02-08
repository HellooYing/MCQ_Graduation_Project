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
    private Long user_id;

    /**
     * 权限类型
     */
    private Integer authority_type;

    @Override
    public String toString() {
        return "UserAuthority{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", authority_type=" + authority_type +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getAuthority_type() {
        return authority_type;
    }

    public void setAuthority_type(Integer authority_type) {
        this.authority_type = authority_type;
    }

    public UserAuthority(Long user_id, Integer authority_type) {
        this.user_id = user_id;
        this.authority_type = authority_type;
    }

    public UserAuthority() {
    }

    public UserAuthority(Long id, Long user_id, Integer authority_type) {
        this.id = id;
        this.user_id = user_id;
        this.authority_type = authority_type;
    }
}
