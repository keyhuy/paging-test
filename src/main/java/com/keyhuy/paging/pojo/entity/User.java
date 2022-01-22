package com.keyhuy.paging.pojo.entity;

/**
 * 用户实体
 *
 * @author Key
 * @date 2022/01/22/10:40
 **/
public class User {

    private Integer userId;
    private String userName;
    private Integer gender;
    private String phone;

    public User() {
    }

    public User(Integer userId, String userName, Integer gender, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
}
