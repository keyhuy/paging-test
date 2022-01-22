package com.keyhuy.paging.dao.impl;

import com.keyhuy.paging.dao.UserDao;
import com.keyhuy.paging.pojo.entity.User;
import com.keyhuy.paging.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久层接口实现类-用户
 *
 * @author Key
 * @date 2022/01/22/10:54
 **/
public class UserDaoImpl implements UserDao {

    /**
     * 根据用户编号获取用户记录
     */
    @Override
    public User getUserById(Integer userId) {
        return null;
    }

    /**
     * 查询所有用户记录
     */
    @Override
    public List<User> listAllUsers() {
        return null;
    }

    /**
     * 分页查询用户记录
     */
    @Override
    public List<User> listPageUsers(int start, int count) {

        // 初始化各个对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 获取连接对象
            conn = DbUtils.getConn();

            // 创建SQL语句
            String sql = "select * from `user` limit ?, ?";

            // 创建ps对象
            ps = conn.prepareStatement(sql);

            // 填充占位符
            ps.setInt(1, start);
            ps.setInt(2, count);

            // 执行SQL，获取结果集
            rs = ps.executeQuery();

            // 用户集合，存储每个用户信息
            List<User> users = new ArrayList<>();

            // 处理结果集
            while (rs.next()) {
                // 创建用户对象，存储数据
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setGender(rs.getInt("gender"));
                user.setPhone(rs.getString("phone"));

                // 存入集合
                users.add(user);
            }

            // 返回集合
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DbUtils.closeResource(rs, ps, conn);
        }

        return null;
    }

    /**
     * 查询总记录数
     */
    @Override
    public int countAll() {

        // 初始化各个对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 获取连接对象
            conn = DbUtils.getConn();

            // 创建SQL语句
            String sql = "select count(*) from `user`";

            // 创建ps对象
            ps = conn.prepareStatement(sql);

            // 执行SQL，获取结果集
            rs = ps.executeQuery();

            // 记住统计结果
            int count = 0;

            // 处理结果集
            while (rs.next()) {
                count = rs.getInt(1);
            }

            // 返回结果，不可直接返回rs.getInt(1)
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DbUtils.closeResource(rs, ps, conn);
        }

        return 0;
    }
}
