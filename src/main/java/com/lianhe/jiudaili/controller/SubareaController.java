package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.SubareaService;
import com.lianhe.jiudaili.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(value = "酒水分区类别相关操作", tags = "区域类别相关方法")
@RestController
@RequestMapping("/jiudaili/subarea")
public class SubareaController {
	@Autowired
    private SubareaService subareaService;

    @GetMapping("all.do")
    @ApiOperation(value = "展示酒水分区类别")
    public ResultVo all() {
        return subareaService.selectAll();
    }

    @PostMapping("selectbyid.do")
    @ApiOperation(value = "展示指定区域的酒水公司")
    public ResultVo selectById(int id) {
        return subareaService.selectById(id);
    }
}
