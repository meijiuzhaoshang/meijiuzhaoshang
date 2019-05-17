package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianhe.jiudaili.dao.*;
import com.lianhe.jiudaili.entity.Company;
import com.lianhe.jiudaili.entity.CompanyInvest;
import com.lianhe.jiudaili.entity.CompanyPrice;
import com.lianhe.jiudaili.entity.Price;
import com.lianhe.jiudaili.service.PriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-17
 */
@Service
public class PriceServiceImpl extends ServiceImpl<PriceMapper, Price> implements PriceService {
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private CompanyPriceMapper companyPriceMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK",priceMapper.selectList(new QueryWrapper<Price>()));
    }

    @Override
    public ResultVo selectById(int id) {
        List<Company> coms = new ArrayList<>();
        List<CompanyPrice> companyPrices = companyPriceMapper.selectList(new QueryWrapper<CompanyPrice>().eq("vid", id));
        for (CompanyPrice companyPrice:companyPrices) {
            coms.add(companyMapper.selectById(companyPrice.getCid()));
        }
        return ResultUtil.exec(true,"OK",coms);
    }
}
