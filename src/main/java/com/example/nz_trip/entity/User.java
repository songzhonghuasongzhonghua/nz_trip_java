package com.example.nz_trip.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


public class User {
    private int id;
    private String username;
    private String password;
    private Integer sex; //0-女生 1-男生

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", roleType=" + roleType +
                ", phone='" + phone + '\'' +
                ", createAt=" + createAt +
                ", birthAt=" + birthAt +
                '}';
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String avatar;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private int roleType; //0-普通用户 1-管理员
    private String phone;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public java.util.Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(java.util.Date createAt) {
        this.createAt = createAt;
    }

    public java.util.Date getBirthAt() {
        return birthAt;
    }

    public void setBirthAt(java.util.Date birthAt) {
        this.birthAt = birthAt;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date birthAt;



    public User(String username,String password,String phone,int roleType,java.util.Date createAt) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.roleType = roleType;
        this.createAt = createAt;
    }

    public User(){}
}
