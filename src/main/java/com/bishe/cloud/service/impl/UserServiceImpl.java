package com.bishe.cloud.service.impl;

import com.bishe.cloud.dao.AuthorityTypeDAO;
import com.bishe.cloud.dao.LoginTicketDAO;
import com.bishe.cloud.dao.UserAuthorityDAO;
import com.bishe.cloud.dao.UserDAO;
import com.bishe.cloud.model.AuthorityType;
import com.bishe.cloud.model.LoginTicket;
import com.bishe.cloud.model.User;
import com.bishe.cloud.model.UserAuthority;
import com.bishe.cloud.service.UserService;
import com.bishe.cloud.util.ToutiaoUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserDAO userDAO;
    @Resource
    private LoginTicketDAO loginTicketDAO;
    @Resource
    AuthorityTypeDAO authorityTypeDAO;
    @Resource
    UserAuthorityDAO userAuthorityDAO;

    @Override
    public Map<String, Object> register(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user != null) {
            map.put("msgname", "用户名已经被注册");
            return map;
        }

        // 密码强度
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String head = String.format("http://images.bishe.cloud.com/head/%dt.png", new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(ToutiaoUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);

        // 登陆
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user == null) {
            map.put("msgname", "用户名不存在");
            return map;
        }

        if (!ToutiaoUtil.MD5(password+user.getSalt()).equals(user.getPassword())) {
            map.put("msgpwd", "密码不正确");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }
    @Override
    public User getUser(int id) {
        return userDAO.selectById(id);
    }

    @Override
    public void logout(String ticket) {
        loginTicketDAO.updateStatus(ticket, 1);
    }

    @Override
    public int addAuthorityType(AuthorityType authorityType) {
        return authorityTypeDAO.insert(authorityType);
    }

    @Override
    public int renameAuthorityType(int authorityType, String name) {
        return authorityTypeDAO.updateByPrimaryKeySelective(new AuthorityType(authorityType,name));
    }

    @Override
    public int deleteAuthorityType(int authorityType) {
        return authorityTypeDAO.deleteByPrimaryKey(authorityTypeDAO);
    }

    @Override
    public AuthorityType getAuthorityType(int authorityType) {
        return authorityTypeDAO.selectByPrimaryKey(new AuthorityType(authorityType));
    }

    @Override
    public int addUserAuthority(UserAuthority userAuthority) {
        return userAuthorityDAO.insert(userAuthority);
    }

    @Override
    public int deleteUserAuthority(long id) {
        return userAuthorityDAO.deleteByPrimaryKey(new UserAuthority(id));
    }

    @Override
    public List<UserAuthority> getUserAuthorityByUserId(int userId) {
        return userAuthorityDAO.selectByUserId(userId);
    }

    @Override
    public boolean userHasAuthority(int userId, int authorityType) {
        int count=userAuthorityDAO.selectCountByUserIdAndAuthority(userId,authorityType);
        if(count==0) {
            return false;
        }
        else {
            return true;
        }
    }

    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }
}
