package com.keyhuy.paging.dao;

import com.keyhuy.paging.dao.impl.UserDaoImpl;
import com.keyhuy.paging.pojo.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Key
 * @date 2022/01/22/13:59
 **/
public class UserDaoTest {

    private final UserDao userDao = new UserDaoImpl();

    @Test
    public void listPageUsers() {
        List<User> users = userDao.listPageUsers(0, 3);

        users.forEach(System.out :: println);
    }

    @Test
    public void countAll() {
        int num = userDao.countAll();
        System.out.println(num);
    }
}