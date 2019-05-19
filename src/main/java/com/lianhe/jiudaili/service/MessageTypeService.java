package com.lianhe.jiudaili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.MessageType;
import com.lianhe.jiudaili.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
public interface MessageTypeService extends IService<MessageType> {
	//查询所有信息类型
    ResultVo findAll();
}
