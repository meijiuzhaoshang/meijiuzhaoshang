package com.lianhe.jiudaili.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.MessageTypeMapper;
import com.lianhe.jiudaili.entity.MessageType;
import com.lianhe.jiudaili.service.MessageTypeService;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
@Service
public class MessageTypeServiceImpl extends ServiceImpl<MessageTypeMapper, MessageType> implements MessageTypeService {
    @Autowired
    private MessageTypeMapper messageTypeMapper;

    @Override
    public ResultVo findAll() {
        return ResultUtil.exec(true,"OK",messageTypeMapper.selectList(new QueryWrapper<MessageType>()));
    }
}
