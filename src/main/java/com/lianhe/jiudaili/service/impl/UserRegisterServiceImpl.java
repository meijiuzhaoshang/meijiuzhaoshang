package com.lianhe.jiudaili.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.UserRegisterMapper;
import com.lianhe.jiudaili.entity.UserRegister;
import com.lianhe.jiudaili.service.UserRegisterService;
import com.lianhe.jiudaili.utils.*;
import com.lianhe.jiudaili.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@Service
public class UserRegisterServiceImpl extends ServiceImpl<UserRegisterMapper, UserRegister> implements UserRegisterService {

    @Autowired
    private UserRegisterMapper userRegisterMapper;

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public ResultVo register(UserRegisterVo userRegisterVo) {

        UserRegister userRegister = new UserRegister();

        userRegister.setCreatetime(new Date());
        userRegister.setUserName(userRegisterVo.getUserName());
        userRegister.setPassword(userRegisterVo.getPassword());
        userRegister.setPhone(userRegisterVo.getPhone());
        userRegister.setEmail(userRegisterVo.getEmail());
        userRegister.setFlag(1);
        userRegister.setUserType(userRegisterVo.getUserType());

        //校验该用户名是否已存在
        QueryWrapper<UserRegister> queryWrapper = new QueryWrapper<UserRegister>().eq("user_name", userRegister.getUserName());
        if (userRegister.selectOne(queryWrapper) != null) {
            return ResultUtil.exec(false, "注册失败，该用户名已存在，请更换用户名", null);
        }

        //校验该手机号是否已存在
        QueryWrapper<UserRegister> queryWrapper2 = new QueryWrapper<UserRegister>().eq("phone", userRegister.getPhone());
        if (userRegister.selectOne(queryWrapper2) != null) {
            return ResultUtil.exec(false, "注册失败，该手机号已被注册过，请勿重复注册", null);
        }

        return ResultUtil.exec(userRegisterMapper.save(userRegister) > 0, "注册成功", null);
    }

    /*
    @Override
    public ResultVo checkPhone(String phone) {
        QueryWrapper<UserRegister> queryWrapper = new QueryWrapper<UserRegister>().eq("phone", phone);
        return ResultUtil.exec(userRegisterMapper.selectOne(queryWrapper) != null, "该手机号已被注册过", null);
    }
    */
    @Override
    public ResultVo login(UserLoginVo userLoginVo) {
        String userName = userLoginVo.getUserName();
        QueryWrapper<UserRegister> queryWrapper = new QueryWrapper<UserRegister>().eq("user_name", userName);
        UserRegister userRegister = userRegisterMapper.selectOne(queryWrapper);
        if (userRegister != null) {
            if (userRegister.getPassword().equals(userLoginVo.getPassword())) {
                //1、生成Token
                String userToken = TokenUtil.createToken(userRegister.getId(), userName);
                //2、存储到Redis
                //记录Token有效期30分钟
                jedisUtil.setStr("user:" + userName, userToken, 1800);
                //记录当前登录用户的详细信息
                jedisUtil.setStr(userToken, JSON.toJSONString(userRegister), 1800);
                //3、存储到Cookie
                /*Cookie cookie = new Cookie("usertoken", token);
                cookie.setPath("/");
                response.addCookie(cookie);*/
                return ResultUtil.exec(true, "登录成功", userToken);
            }
        }
        return ResultUtil.exec(false, "用户名或密码不正确", null);
    }

    @Override
    public ResultVo checkLogin(String userToken) {
       /*Cookie[] arr = request.getCookies();
        String token = "";
        for (Cookie c : arr) {
            if (c.getName().equals("usertoken")) {
                token = c.getValue();
                break;
            }
        }*/
        if (userToken.length() > 0) {
            //token存在
            if (jedisUtil.isExists(userToken)) {
                //有效
                String json = jedisUtil.getStr(userToken);
                UserRegister userRegister = JSON.parseObject(json, UserRegister.class);
                UserVo userVo = new UserVo();
                userVo.setId(userRegister.getId());
                userVo.setUserName(userRegister.getUserName());
                userVo.setPhone(userRegister.getPhone());
                userVo.setEmail(userRegister.getEmail());
                userVo.setUserTypeNum(userRegister.getUserType());
                if (userRegister.getUserType() == 1) {
                    //1 表示厂家 2 表示经销商
                    userVo.setUserType("厂家");
                } else if (userRegister.getUserType() == 2) {
                    userVo.setUserType("经销商");
                }
                userVo.setCreatetime(userRegister.getCreatetime());

                return ResultUtil.exec(true, "已经登录，且有效", userVo);
            } else {
                return ResultUtil.exec(false, "Token已经失效，请重新登录", null);
            }
        } else {
            return ResultUtil.setERROR();
        }
    }

    @Override
    public ResultVo exitLogin(String token, HttpServletResponse response) {
        /*Cookie[] arr = request.getCookies();
        String token = "";
        for (Cookie c : arr) {
            if (c.getName().equals("usertoken")) {
                token = c.getValue();
                break;
            }
        }*/
        //删除Redis
        String json = jedisUtil.getStr(token);
        UserRegister userRegister = JSON.parseObject(json, UserRegister.class);
        UserVo userVo = new UserVo();
        userVo.setId(userRegister.getId());
        userVo.setUserName(userRegister.getUserName());
        userVo.setPhone(userRegister.getPhone());
        userVo.setEmail(userRegister.getEmail());
        userVo.setUserTypeNum(userRegister.getUserType());
        jedisUtil.delKey(token);
        TokenVO tokenVO = TokenUtil.parseToken(token);
        jedisUtil.delKey("user:" + tokenVO.getContent());
        //删除Cookie
        Cookie cookie = new Cookie("usertoken", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResultUtil.exec(true, "注销成功", userVo);
    }

    @Override
    public ResultVo sendCode(String phone) {
        int code = RandomUtil.createNum(4);

        //生成Token
        String phoneToken = TokenUtil.createToken(code, phone);
        //2、存储到Redis
        //记录Token有效期5分钟
        jedisUtil.setStr("phone:" + phone, phoneToken, 300);
        // jedisUtil.setStr(token, JSON.toJSONString(userRegister), 300);
        //3、存储到Cookie
        /*Cookie cookie = new Cookie("phoneCode", "phoneCode:" + phone);
        cookie.setPath("/");
        response.addCookie(cookie);*/

        return ResultUtil.exec(AliyunSmsUtil.sendSms(phone, code), "手机验证码", null);
    }

    @Override
    public ResultVo checkCode(String phone, int code) {
        /*Cookie[] arr = request.getCookies();
        String tokenKey = "";
        for (Cookie c : arr) {
            if (c.getName().equals("phoneCode")) {
                tokenKey = c.getValue();
                break;
            }
        }*/
        //token存在
        if (jedisUtil.isExists("phone:" + phone)) {
            //有效
            String phoneToken = jedisUtil.getStr("phone:" + phone);

            TokenVO tokenVO = TokenUtil.parseToken(phoneToken);

            if (tokenVO.getContent().equals(phone)) {
                if (tokenVO.getUid() == code) {
                    return ResultUtil.exec(true, "验证码输入正确", null);
                }
            }
            return ResultUtil.exec(false, "验证码错误", null);
        } else {
            return ResultUtil.exec(false, "验证码已经失效，请重新获取验证码", null);
        }
    }
}
