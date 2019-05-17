package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.CompanyHomepageService;
import com.lianhe.jiudaili.service.CompanyService;
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
@Api(value = "首页公司相关操作", tags = "首页公司相关方法")
@RestController
@RequestMapping("/jiudaili/company")
public class CompanyController {
	@Autowired
    private CompanyService companyService;
	@Autowired
    private CompanyHomepageService companyHomepageService;

	@GetMapping("/all.do")
    @ApiOperation(value = "展示首页部分公司头像")
    public ResultVo selectAll(){
	    return companyService.selectAll();
    }

    @GetMapping("/newproducts.do")
    @ApiOperation(value = "展示畅销新品公司图片")
    public ResultVo selectAllNew(){
	    return companyHomepageService.selectAll();
    }

    @PostMapping("/selectbyid.do")
    @ApiOperation(value = "根据id展示公司详情")
    public ResultVo selectById(int id){
	    return companyService.selectById(id);
    }
}
