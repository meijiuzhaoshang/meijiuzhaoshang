package com.lianhe.jiudaili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.CompanyHomepage;
import com.lianhe.jiudaili.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
public interface CompanyHomepageService extends IService<CompanyHomepage> {
    //展示所有首页需要的公司信息
    ResultVo selectAll();
}
