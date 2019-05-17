package com.lianhe.jiudaili.service;

import com.lianhe.jiudaili.entity.Brand;
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
public interface BrandService extends IService<Brand> {
    //展示所有的品牌
    ResultVo selectAll();

    //展示指定品牌下的所有公司
    ResultVo selectById(int id);
}
