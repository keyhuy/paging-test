package com.keyhuy.paging.pojo.dto;

/**
 * 用户传输对象
 *  - 继承分页dto
 *
 * @author Key
 * @date 2022/01/22/10:43
 **/
public class UserDTO extends PageDTO<UserDTO> {

    private Integer userId;
    private String phone;

    public UserDTO() {
    }

    public UserDTO(Integer userId, String phone) {
        this.userId = userId;
        this.phone = phone;
    }

    public UserDTO(Integer currPage, Integer pageSize, String pageDataKey, Integer userId, String phone) {
        super(currPage, pageSize, pageDataKey);
        this.userId = userId;
        this.phone = phone;
    }

    public UserDTO(Integer currPage, Integer pageSize, Integer userId, String phone) {
        super(currPage, pageSize);
        this.userId = userId;
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", phone='" + phone + '\'' +
                '}';
    }
}
