package com.lianhe.jiudaili.service;

import com.lianhe.jiudaili.entity.FamousDrinks;
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
public interface FamousDrinksService extends IService<FamousDrinks> {
    //展示所有的名酒代理
    ResultVo selectAll();


}
