package com.keyhuy.paging.dao;

import com.keyhuy.paging.pojo.entity.User;

import java.util.List;

/**
 * 持久层接口-用户
 *
 * @author Key
 * @date 2022/01/22/10:50
 **/
public interface UserDao {

    /**
     * 根据用户编号获取用户记录
     * @param userId 用户编号
     * @return 返回用户对象
     */
    User getUserById(Integer userId);

    /**
     * 查询所有用户记录
     * @return 返回用户集合
     */
    List<User> listAllUsers();

    /**
     * 分页查询用户记录
     * @param start 开始索引
     * @param count 查询数量
     * @return 返回用户集合
     */
    List<User> listPageUsers(int start, int count);

    /**
     * 查询总记录数
     * @return 返回数量
     */
    int countAll();
}