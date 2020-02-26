package com.bishe.cloud.model;

import java.util.Date;


public class LoginTicket {
    private Integer id;
    private Integer userId;
    private Date expired;
    private Integer status;// 0有效，1无效
    private String ticket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public LoginTicket(Integer id, Integer userId, Date expired, Integer status, String ticket) {
        this.id = id;
        this.userId = userId;
        this.expired = expired;
        this.status = status;
        this.ticket = ticket;
    }

    public LoginTicket() {
    }

    public LoginTicket(Integer userId, Date expired, Integer status, String ticket) {
        this.userId = userId;
        this.expired = expired;
        this.status = status;
        this.ticket = ticket;
    }

    public LoginTicket(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoginTicket{" +
                "id=" + id +
                ", userId=" + userId +
                ", expired=" + expired +
                ", status=" + status +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
