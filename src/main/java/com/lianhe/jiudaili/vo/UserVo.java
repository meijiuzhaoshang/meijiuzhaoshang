package com.lianhe.jiudaili.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserVo {
    private Integer id;
    private String userName;
    private String phone;
    private String email;
    private Integer userTypeNum;
    private String userType;//厂家/经销商
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    public Integer getUserTypeNum() {
        return userTypeNum;
    }

    public void setUserTypeNum(Integer userTypeNum) {
        this.userTypeNum = userTypeNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
