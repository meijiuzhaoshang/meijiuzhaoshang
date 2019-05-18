package com.lianhe.jiudaili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.UserDetail;
import com.lianhe.jiudaili.vo.ResultVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 酒代理后端开发小组——冯志立、龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-17
 */
public interface UserDetailService extends IService<UserDetail> {

    //修改/完善个人资料，通过token获取用户ID
    ResultVo updateUserDetail(String userToken, String name, String nick,
                              String phone, String tel, String qqcard,
                              String email, String uaddress);

    //修改密码，通过token获取用户ID
    ResultVo updatePassword(String userToken, String orPassword, String password, String rePassword);

    //注销用户
    ResultVo cancelUser(String userToken);

    //获取用户信息用于绑定数据
    ResultVo getUserInfo(String userToken);
}
