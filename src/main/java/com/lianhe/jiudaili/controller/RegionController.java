package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.RegionService;
import com.lianhe.jiudaili.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@Api(value = "首页地区相关操作", tags = "首页地区相关方法")
@RestController
@RequestMapping("/jiudaili/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("all.do")
    @ApiOperation(value = "展示首页所有地区信息")
    public ResultVo all() {
        return regionService.selectAll();
    }

    @GetMapping("allSecondRegion.do")
    @ApiOperation(value = "展示首页所有二级地区信息")
    public ResultVo selectAllSecondRegion() {
        return regionService.selectAllSecondRegion();
    }
}
