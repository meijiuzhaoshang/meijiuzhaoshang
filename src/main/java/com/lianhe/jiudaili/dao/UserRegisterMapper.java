package com.lianhe.jiudaili.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianhe.jiudaili.entity.UserRegister;
import org.apache.ibatis.annotations.*;

import java.util.Date;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
public interface UserRegisterMapper extends BaseMapper<UserRegister> {
    @Insert("insert into user_register(user_name,password,phone,email,user_type,createtime,flag) values(#{userName},#{password},#{phone},#{email},#{userType},#{createtime},1)")
    @Options(useGeneratedKeys = true, keyProperty = "id")//获取自增主键的值
    int save(UserRegister userRegister);

    //查找用户id,用户名，手机号和邮箱
    @Select("select id,user_name,phone,email from user_register where id=#{id}")
    UserRegister selectById(Integer id);

    //查找用户创建时间
    @Select("select createtime from user_register where id=#{id}")
    Date selectCreatetimeById(Integer id);

    //查找用户密码
    @Select("select password from user_register where id=#{id}")
    String selectPasswordById(Integer id);

    //修改用户的手机号和密码
    @Update("UPDATE user_register SET phone = #{phone},email=#{email} WHERE id = #{id}")
    void updatePhoneAndEmailById(@Param("phone") String phone, @Param("email") String email,
                                 @Param("id") Integer id);

    //修改密码
    @Update("UPDATE user_register SET password = #{password} WHERE id = #{id}")
    void updatePasswordById(@Param("password") String password, @Param("id") Integer id);
}