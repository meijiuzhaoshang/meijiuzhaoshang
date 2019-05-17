package com.lianhe.jiudaili.service;

import com.lianhe.jiudaili.entity.Channel;
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
public interface ChannelService extends IService<Channel> {
    //展示所有的渠道
    ResultVo selectAll();

    //根据指定渠道展示所有公司
    ResultVo selectById(int id);
}
