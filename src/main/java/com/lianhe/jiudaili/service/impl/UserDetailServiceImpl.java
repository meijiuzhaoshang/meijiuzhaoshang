package com.lianhe.jiudaili.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.UserDetailMapper;
import com.lianhe.jiudaili.dao.UserRegisterMapper;
import com.lianhe.jiudaili.entity.UserDetail;
import com.lianhe.jiudaili.entity.UserRegister;
import com.lianhe.jiudaili.service.UserDetailService;
import com.lianhe.jiudaili.utils.JedisUtil;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.ResultVo;
import com.lianhe.jiudaili.vo.UserDetailVo;
import com.lianhe.jiudaili.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 酒代理后端开发小组——冯志立、龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-17
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {

    @Autowired
    private UserRegisterMapper userRegisterMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public ResultVo getUserInfo(String userToken) {
        //解析token
        if (userToken.length() > 0) {
            //token存在
            if (jedisUtil.isExists(userToken)) {
                //有效
                String json = jedisUtil.getStr(userToken);
                //获取用户注册表信息
                UserRegister userRegister = JSON.parseObject(json, UserRegister.class);
                //UserRegister userRegister = userRegisterMapper.selectById(user.getId());
                //获取用户详情信息
                UserDetail userDetail = userDetailMapper.selectById(userRegister.getId());

                UserDetailVo userVo = new UserDetailVo();
                userVo.setId(userRegister.getId());
                userVo.setUserName(userRegister.getUserName());
                userVo.setPhone(userRegister.getPhone());
                userVo.setEmail(userRegister.getEmail());
                userVo.setName(userDetail.getName());
                userVo.setNick(userDetail.getNick());
                userVo.setTel(userDetail.getTel());
                userVo.setQqcard(userDetail.getQqcard());
                userVo.setUaddress(userDetail.getUaddress());

                return ResultUtil.exec(true, "查询成功", userVo);
            } else {
                return ResultUtil.exec(false, "查询失败", null);
            }
        } else {
            return ResultUtil.setERROR();
        }
    }

    @Override
    @Transactional
    public ResultVo updateUserDetail(String userToken, String name, String nick, String phone, String tel, String qqcard, String email, String uaddress) {
        //解析token
        if (userToken.length() > 0) {
            //token存在
            if (jedisUtil.isExists(userToken)) {//有效
                String json = jedisUtil.getStr(userToken);
                //获取用户注册表信息
                UserRegister userRegister = JSON.parseObject(json, UserRegister.class);

                userRegisterMapper.updatePhoneAndEmailById(phone, email, userRegister.getId());

                userDetailMapper.updateInfoById(name, nick, tel, uaddress, qqcard, userRegister.getId());

                UserVo userVo = new UserVo();
                userVo.setId(userRegister.getId());
                userVo.setUserName(userRegister.getUserName());

                return ResultUtil.exec(true, "修改成功", userVo);
            } else {
                return ResultUtil.exec(false, "修改失败", null);
            }
        } else {
            return ResultUtil.setERROR();
        }
    }

    @Override
    public ResultVo updatePassword(String userToken, String orPassword, String password, String rePassword) {
        //解析token
        if (userToken.length() > 0) {
            //token存在
            if (jedisUtil.isExists(userToken)) {//有效
                String json = jedisUtil.getStr(userToken);
                //获取用户注册表信息
                UserRegister userRegister = JSON.parseObject(json, UserRegister.class);

                //校验原密码是否正确
                String pass = userRegisterMapper.selectPasswordById(userRegister.getId());

                if (!pass.equals(orPassword)) {
                    return ResultUtil.exec(false, "修改失败,原密码不正确", null);
                }

                if (!password.equals(rePassword)) {
                    return ResultUtil.exec(false, "修改失败,两次输入密码不一致", null);
                }

                userRegisterMapper.updatePasswordById(password, userRegister.getId());

                UserVo userVo = new UserVo();
                userVo.setId(userRegister.getId());
                userVo.setUserName(userRegister.getUserName());

                return ResultUtil.exec(true, "修改成功", userVo);
            } else {
                return ResultUtil.exec(false, "修改失败", null);
            }
        } else {
            return ResultUtil.setERROR();
        }

    }

    @Override
    public ResultVo cancelUser(String userToken) {
        //1.账号处于正常状态，账号没有被盗，被封等风险。

        //2.账号注册时间需满三个月。

        //3.请确保您目前不是合作客户。

        //4.发布的信息已删除。

        //5.以企业为单位的需要提供营业执照。
        return null;
    }

}
