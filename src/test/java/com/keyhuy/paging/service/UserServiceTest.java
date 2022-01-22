package com.keyhuy.paging.service;

import com.keyhuy.paging.pojo.dto.UserDTO;
import com.keyhuy.paging.pojo.vo.PageVO;
import com.keyhuy.paging.pojo.vo.UserVO;
import com.keyhuy.paging.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Key
 * @date 2022/01/22/15:42
 **/
public class UserServiceTest {

    private final UserService userService = new UserServiceImpl();

    @Test
    public void listPageUsersInfo() {

        UserDTO userDTO = new UserDTO(2, 3, 101, "123");

        PageVO<UserVO> p = userService.listPageUsersInfo(userDTO);
        System.out.println(p);
    }
}