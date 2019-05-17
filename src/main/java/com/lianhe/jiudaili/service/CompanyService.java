package com.lianhe.jiudaili.service;

import com.lianhe.jiudaili.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
public interface CompanyService extends IService<Company> {
    //展示所有的部分公司头像
    ResultVo selectAll();

    //根据id展示公司详情
    ResultVo selectById(int id);
}
