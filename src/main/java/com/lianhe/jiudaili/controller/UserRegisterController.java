package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.UserRegisterService;
import com.lianhe.jiudaili.vo.ResultVo;
import com.lianhe.jiudaili.vo.UserLoginVo;
import com.lianhe.jiudaili.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@Api(value = "用户相关操作", tags = "用户相关方法")
@RestController
@RequestMapping("/jiudaili/userRegister")
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    @ApiOperation(value = "注册用户", notes = "实现用户的新增")
    @PostMapping("/register.do")
    public ResultVo save(@RequestBody @ApiParam(name = "userRegisterVo", value = "用户注册表相关的键值对") UserRegisterVo userRegisterVo) {
        return userRegisterService.register(userRegisterVo);
    }

    /*
    @ApiOperation(value = "检验用户手机号", notes = "实现用户的手机号校验")
    @PostMapping("/checkPhone.do")
    public ResultVo check(String phone) {
        return userRegisterService.checkPhone(phone);
    }
    */


    @ApiOperation(value = "用户登录", notes = "实现用户登录")
    @PostMapping("/login.do")
    public ResultVo login(@RequestBody @ApiParam(name = "userLoginVo", value = "用户注册表相关的键值对") UserLoginVo userLoginVo, HttpServletResponse response) {
        return userRegisterService.login(userLoginVo);
    }

    @ApiOperation(value = "校验登录是否有效,返回值userTypeNum的值，1表示厂家，2表示经销商", notes = "校验登录是否有效")
    @GetMapping("/checkLogin.do")
    public ResultVo checkLogin(String userToken) {
        return userRegisterService.checkLogin(userToken);
    }

    /*
    @ApiOperation(value = "校验登录是否有效", notes = "校验登录是否有效")
    @GetMapping("user/{version}/checklogin.do")
    public ResultVo checkLogin2(HttpServletRequest request, @PathVariable String version) {
        return userRegisterService.checkLogin(request);
    }
    */

    @ApiOperation(value = "注销", notes = "注销")
    @GetMapping("/exitLogin.do")
    public ResultVo exit(String userToken, HttpServletResponse response) {
        return userRegisterService.exitLogin(userToken, response);
    }

    @ApiOperation(value = "发送手机验证码", notes = "发送手机验证码")
    @GetMapping("/sendCode.do")
    public ResultVo sendCode(String phone) {
        return userRegisterService.sendCode(phone);
    }

    @ApiOperation(value = "验证手机验证码", notes = "验证手机验证码")
    @GetMapping("/checkCode.do")
    public ResultVo checkCode(String phone, int code) {
        return userRegisterService.checkCode(phone, code);
    }
}
