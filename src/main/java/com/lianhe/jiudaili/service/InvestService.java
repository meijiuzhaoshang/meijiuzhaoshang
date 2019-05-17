package com.lianhe.jiudaili.service;

import com.lianhe.jiudaili.entity.Invest;
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
public interface InvestService extends IService<Invest> {
    //展示所有的投资额度
    ResultVo selectAll();

    //根据指定的投资额度展示所有公司
    ResultVo selectById(int id);
}
