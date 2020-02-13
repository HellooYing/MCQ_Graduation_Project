package com.bishe.cloud.dao;

import com.bishe.cloud.model.AuthorityType;
import com.bishe.cloud.model.UserAuthority;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 9:23 下午
 */
public interface UserAuthorityDAO extends Mapper<UserAuthority> {
    @Select({"select id,user_id,authority_type from user_authority where user_id=#{userId}"})
    List<UserAuthority> selectByUserId(@Param("userId") int userId);

    @Select({"select count(*) from user_authority where user_id=#{userId} and authority_type=#{authorityType}"})
    int selectCountByUserIdAndAuthority(@Param("userId") int userId,@Param("authorityType") int authorityType);
}
