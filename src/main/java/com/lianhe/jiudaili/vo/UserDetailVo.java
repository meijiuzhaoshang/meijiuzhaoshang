package com.lianhe.jiudaili.vo;

public class UserDetailVo {
    private Integer id;
    private String userName;//用户名
    private String name;//姓名
    private String nick;//昵称
    private String phone;//手机号
    private String tel;//固定电话
    private String qqcard;//qq号
    private String email;//邮箱
    private String uaddress;//地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQqcard() {
        return qqcard;
    }

    public void setQqcard(String qqcard) {
        this.qqcard = qqcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }
}
