package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.InvestService;
import com.lianhe.jiudaili.service.MessageTypeService;
import com.lianhe.jiudaili.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
@Api(value = "信息类型相关操作", tags = "信息类型相关方法")
@RestController
@RequestMapping("/jiudaili/messageType")
public class MessageTypeController {
    @Autowired
    private MessageTypeService messageTypeService;

    @GetMapping("/all.do")
    @ApiOperation(value = "展示所有信息类型")
    public ResultVo selectAll(){
        return messageTypeService.findAll();
    }
}
