package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.UserDetailService;
import com.lianhe.jiudaili.vo.ResultVo;
import com.lianhe.jiudaili.vo.UserLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 酒代理后端开发小组——冯志立、龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-17
 */
@Api(value = "用户个人资料相关", tags = "用户个人资料相关")
@RestController
@RequestMapping("/jiudaili/userDetail")
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    //修改/完善个人资料，通过token获取用户ID
    @ApiOperation(value = "修改/完善个人资料", notes = "修改/完善个人资料")
    @GetMapping("/updateUserDetail.do")
    public ResultVo updateUserDetail(String userToken, String name, String nick,
                                     String phone, String tel, String qqcard,
                                     String email, String uaddress) {
        return userDetailService.updateUserDetail(userToken, name, nick, phone, tel, qqcard, email, uaddress);
    }

    //修改密码，通过token获取用户ID
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @GetMapping("/updatePassword.do")
    public ResultVo updatePassword(String userToken, String orPassword, String password, String rePassword) {
        return userDetailService.updatePassword(userToken, orPassword, password, rePassword);
    }

    //注销用户
    /*ResultVo cancelUser(String userToken);
     */
    //获取用户信息用于绑定数据
    @ApiOperation(value = "获取用户信息用于绑定数据", notes = "获取用户信息用于绑定数据")
    @GetMapping("/getUserInfo.do")
    ResultVo getUserInfo(String userToken) {
        return userDetailService.getUserInfo(userToken);
    }
}
