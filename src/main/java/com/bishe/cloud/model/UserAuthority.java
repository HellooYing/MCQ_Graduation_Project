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
}
