package com.lianhe.jiudaili.service;

import com.lianhe.jiudaili.entity.Price;
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
public interface PriceService extends IService<Price> {
    //展示所有的市场价位
    ResultVo selectAll();

    //根据指定的价位展示所有公司
    ResultVo selectById(int id);
}
