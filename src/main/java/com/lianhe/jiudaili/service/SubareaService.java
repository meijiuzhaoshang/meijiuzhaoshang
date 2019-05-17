package com.lianhe.jiudaili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.Subarea;
import com.lianhe.jiudaili.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
public interface SubareaService extends IService<Subarea> {
    //展示所有的酒水分区类别
    ResultVo selectAll();

    //根据指定的区域类别展示所有公司
    ResultVo selectById(int id);
}
