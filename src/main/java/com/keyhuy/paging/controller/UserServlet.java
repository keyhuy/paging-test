package com.keyhuy.paging.controller;

import com.keyhuy.paging.common.ResultInfo;
import com.keyhuy.paging.pojo.dto.UserDTO;
import com.keyhuy.paging.pojo.vo.PageVO;
import com.keyhuy.paging.pojo.vo.UserVO;
import com.keyhuy.paging.service.UserService;
import com.keyhuy.paging.service.impl.UserServiceImpl;
import com.keyhuy.paging.util.JsonUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 用户Servlet
 *
 * @author Key
 * @date 2022/01/22/11:35
 **/
@WebServlet("/user/pageUsers")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 设置请求编码方式
        req.setCharacterEncoding("utf-8");
        // 设置响应数据格式和编码方式
        resp.setContentType("application/json;charset=utf-8");

        // 根据请求对象request中请求体转成对象
        UserDTO userDTO = JsonUtils.getObjectFromReqBody(req, UserDTO.class);

        // 调用service方法，获取分页对象
        PageVO<UserVO> pageVO = userService.listPageUsersInfo(userDTO);

        // 创建响应对象
        ResultInfo<PageVO<UserVO>> resultInfo =
                new ResultInfo<>(200, "请求成功", pageVO);

        // 将对象转成json字符串
        String resJson = JsonUtils.getJsonFromObject(resultInfo);

        // 判断是否转化成功
        if (null != resJson) {
            // 响应数据
            resp.getWriter().write(resJson);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
