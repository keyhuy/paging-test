package com.keyhuy.paging.pojo.vo;

/**
 * 用户值对象
 *
 * @author Key
 * @date 2022/01/22/10:46
 **/
public class UserVO {

    private Integer userId;
    private String userName;
    private String gender;
    private String phone;

    public UserVO() {
    }

    public UserVO(Integer userId, String userName, String gender, String phone) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
        return "UserVO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
