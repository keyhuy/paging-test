package com.keyhuy.paging.service;

import com.keyhuy.paging.pojo.dto.UserDTO;
import com.keyhuy.paging.pojo.vo.PageVO;
import com.keyhuy.paging.pojo.vo.UserVO;

/**
 * 业务层接口-用户
 *
 * @author Key
 * @date 2022/01/22/11:14
 **/
public interface UserService {

    /**
     * 分页查询用户信息
     * @param userDTO 用户传输对象
     * @return 返回分页VO
     */
    PageVO<UserVO> listPageUsersInfo(UserDTO userDTO);
}