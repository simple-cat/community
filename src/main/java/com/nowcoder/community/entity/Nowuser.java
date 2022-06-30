package com.nowcoder.community.entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class Nowuser {  //对应用户表nowuser
    private int id;   //用户id
    private String username; //用户名
    private String userpass; //密码
    private String salt;  //防止用户密码太简单被轻易破解，所添加的一串随机字符串（这里暂设为5位）
    private String email;  //用户邮箱
    private int userType; //用户类型0-普通用户;1-管理员;2-版主
    private int userStatus; //用户状态0-未激活;1-已激活
    private String activationCode; //激活码
    private String headerUrl;  //用户头像地址
    private Date createTime; //用户注册时间。注意时间类型为Date，不要写错了
    //rmb战士 ： 老师你好，我在学习了下一节项目调试后打断点成功发现问题所在  是private Date createTime；打成了 date  现在已成功解决

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    @Override
    public String toString() {
        return "Nowuser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", userStatus=" + userStatus +
                ", activationCode='" + activationCode + '\'' +
                ", headerUrl='" + headerUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
