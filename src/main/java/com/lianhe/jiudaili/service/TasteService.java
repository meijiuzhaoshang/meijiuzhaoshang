package com.lianhe.jiudaili.service;

import com.lianhe.jiudaili.entity.Taste;
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
public interface TasteService extends IService<Taste> {
    //展示所有的香型
    ResultVo selectAll();

    //根据指定的香型展示所有的公司
    ResultVo selectById(int id);
}
