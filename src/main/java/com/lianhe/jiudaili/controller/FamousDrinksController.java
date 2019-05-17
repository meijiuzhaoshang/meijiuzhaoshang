package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.FamousDrinksService;
import com.lianhe.jiudaili.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "首页名酒代理相关操作", tags = "首页名酒代理相关方法")
@RestController
@RequestMapping("/jiudaili/famousDrinks")
public class FamousDrinksController {
	@Autowired
    private FamousDrinksService famousDrinksService;

    @GetMapping("all.do")
    @ApiOperation(value = "展示首页所有名酒代理信息")
    public ResultVo all() {
        return famousDrinksService.selectAll();
    }
}
