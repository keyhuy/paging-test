package com.keyhuy.paging.service.impl;

import com.keyhuy.paging.dao.UserDao;
import com.keyhuy.paging.dao.impl.UserDaoImpl;
import com.keyhuy.paging.pojo.dto.UserDTO;
import com.keyhuy.paging.pojo.entity.User;
import com.keyhuy.paging.pojo.vo.PageVO;
import com.keyhuy.paging.pojo.vo.UserVO;
import com.keyhuy.paging.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层接口实现类-用户
 *
 * @author Key
 * @date 2022/01/22/11:17
 **/
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    /**
     * 分页查询用户信息
     */
    @Override
    public PageVO<UserVO> listPageUsersInfo(UserDTO userDTO) {
        // 创建一个分页VO，同时设置当前页码和每页数量
        PageVO<UserVO> pageVO = new PageVO<UserVO>().setCurrAndSize(userDTO);

        // 更新当前页码，方便数据库查询
        userDTO = userDTO.calcCurrPage();

        // 查询分页数据
        List<User> users = userDao.listPageUsers(userDTO.getCurrPage(), userDTO.getPageSize());

        // 判断是否获取成功
        if (null == users) {
            return null;
        }

        // 存储vo集合
        List<UserVO> userVOList = new ArrayList<>();

        // 将实体集合转成VO集合
        for (User u : users) {
            UserVO userVO = new UserVO();

            // 也可以使用BeanUtils工具类
            userVO.setUserId(u.getUserId());
            userVO.setUserName(u.getUserName());
            userVO.setGender(u.getGender() == 1 ? "男" : "女");
            userVO.setPhone(u.getPhone());

            // 存入集合
            userVOList.add(userVO);
        }

        // 设置分页数据
        pageVO.setPageDataList(userVOList);

        // 查询总记录数
        int totalCount = userDao.countAll();
        // 设置总记录数和总页码
        pageVO.setTotalPageAndCount(totalCount);

        return pageVO;
    }
}
