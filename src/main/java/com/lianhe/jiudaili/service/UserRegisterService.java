package com.lianhe.jiudaili.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.UserRegister;
import com.lianhe.jiudaili.vo.ResultVo;
import com.lianhe.jiudaili.vo.UserLoginVo;
import com.lianhe.jiudaili.vo.UserRegisterVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
public interface UserRegisterService extends IService<UserRegister> {
    //用户注册
    ResultVo register(UserRegisterVo userRegisterVo);

    //手机号校验
    //ResultVo checkPhone(String phone);

    //用户登录
    ResultVo login(UserLoginVo userLoginVo);

    //校验登录信息
    ResultVo checkLogin(String userToken);

    //退出登录
    ResultVo exitLogin(String userToken, HttpServletResponse response);

    //发送手机验证码
    ResultVo sendCode(String phone);

    //验证手机验证码
    ResultVo checkCode(String phone, int code);
}
