package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianhe.jiudaili.entity.FamousDrinks;
import com.lianhe.jiudaili.dao.FamousDrinksMapper;
import com.lianhe.jiudaili.service.FamousDrinksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class FamousDrinksServiceImpl extends ServiceImpl<FamousDrinksMapper, FamousDrinks> implements FamousDrinksService {
	@Autowired
    private FamousDrinksMapper famousDrinksMapper;

	public ResultVo selectAll(){
        QueryWrapper<FamousDrinks> queryWrapper = new QueryWrapper<>();
	    return ResultUtil.exec(true,"OK",famousDrinksMapper.selectList(queryWrapper));
    }

}
