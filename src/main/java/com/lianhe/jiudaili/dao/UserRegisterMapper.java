package com.lianhe.jiudaili.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianhe.jiudaili.entity.UserRegister;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
public interface UserRegisterMapper extends BaseMapper<UserRegister> {
    @Insert("insert into user_register(user_name,password,phone,email,user_type,createtime,flag) values(#{userName},#{password},#{phone},#{email},#{userType},#{createtime},1)")
    @Options(useGeneratedKeys = true, keyProperty = "id")//获取自增主键的值
    int save(UserRegister userRegister);
}