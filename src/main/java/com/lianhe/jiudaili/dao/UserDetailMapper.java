package com.lianhe.jiudaili.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianhe.jiudaili.entity.UserDetail;
import com.lianhe.jiudaili.entity.UserRegister;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 酒代理后端开发小组——冯志立、龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-17
 */
public interface UserDetailMapper extends BaseMapper<UserDetail> {

    @Update("UPDATE user_detail SET name = #{name},nick=#{nick}," +
            "tel=#{tel},uaddress=#{uaddress},qqcard=#{qqcard} WHERE id = #{id}")
    void updateInfoById(@Param("name") String name, @Param("nick") String nick,
                                @Param("tel") String tel, @Param("uaddress") String uaddress,
                                @Param("qqcard") String qqcard, @Param("id") Integer id);

    @Select("select * from user_detail where id=#{id}")
    UserDetail selectById(Integer id);

    @Insert("insert into user_detail(id) values(#{id})")
    int save(int id);
}