package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.InvestService;
import com.lianhe.jiudaili.service.PriceService;
import com.lianhe.jiudaili.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
@Api(value = "根据价位查询相关操作", tags = "价位相关方法")
@RestController
@RequestMapping("/jiudaili/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping("/all.do")
    @ApiOperation(value = "展示所有价位")
    public ResultVo selectAll(){
        return priceService.selectAll();
    }

    @PostMapping("/selectbyid.do")
    @ApiOperation(value = "根据指定的价位id展示所有公司")
    public ResultVo selectById(int id){
        return priceService.selectById(id);
    }
}
