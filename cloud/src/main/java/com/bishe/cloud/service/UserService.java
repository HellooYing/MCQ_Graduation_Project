package com.bishe.cloud.service;

import com.bishe.cloud.model.AuthorityType;
import com.bishe.cloud.model.User;
import com.bishe.cloud.model.UserAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/8
 * @time: 7:41 下午
 */
public interface UserService {

    Map<String, Object> register(String username, String password);

    Map<String, Object> login(String username, String password);

    User getUser(int id);

    void logout(String ticket);

    //权限类型相关增删改查
    int addAuthorityType(AuthorityType authorityType);
    
    int renameAuthorityType(int authorityType,String name);
    
    int deleteAuthorityType(int authorityType);

    AuthorityType getAuthorityType(int authorityType);
    
    //用户添加权限相关
    int addUserAuthority(UserAuthority userAuthority);
    
    int deleteUserAuthority(long id);

    List<UserAuthority> getUserAuthorityByUserId(int userId);

    /**
     * 用户是否拥有某项权限
     * @param userId
     * @param authorityType
     * @return
     */
    boolean userHasAuthority(int userId,int authorityType);

    List<AuthorityType> getAllType();

    List<UserAuthority> getAllUserAuthority();
}
