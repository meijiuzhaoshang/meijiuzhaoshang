package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.service.DrinksAdvertisementService;
import com.lianhe.jiudaili.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@Api(value = "首页酒水广告相关操作", tags = "首页酒水广告相关方法")
@RestController
@RequestMapping("/jiudaili/drinksAdvertisement")
public class DrinksAdvertisementController {
    /*
	@ApiOperation(value = "单点登录",notes = "实现单点登录")
    @PostMapping("user/login.do")
    public ResultVO login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletResponse response){
        return loginService.login(phone,password,response);
    }
    @ApiOperation(value = "签到",tags = "实现用户的签到")
    @PostMapping("sign/signsave.do")
    public ResultVO sign(@ApiParam(value = "用户登录令牌")String token){
        return signService.sign(TokenUtil.parseToken(token).getUid());
    }
     @CrossOrigin//实现跨域
    @ApiOperation(value = "注册用户",notes = "实现用户的新增")
    @PostMapping("user/usersave.do")
    public ResultVO save(@RequestBody @ApiParam(name = "user",value = "用户相关的键值对") User user){
        return userSrvice.save(user);
    }
    //查询近30天的签到数据
    @GetMapping("sign/signdays.do")
    @ApiOperation(value = "近30天的签到数据",tags = "近30天的签到数据")
    public ResultVO days(@ApiParam(value = "用户登录令牌") String token){
        return signService.days(TokenUtil.parseToken(token).getUid());
    }
	*/

    @Autowired
    private DrinksAdvertisementService drinksAdvertisementService;

    @GetMapping("all.do")
    @ApiOperation(value = "展示首页所有酒水广告信息")
	public ResultVo all() {
        return drinksAdvertisementService.selectAll();
    }
}
