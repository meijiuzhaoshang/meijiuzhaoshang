package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.BrandMapper;
import com.lianhe.jiudaili.dao.CompanyBrandMapper;
import com.lianhe.jiudaili.dao.CompanyMapper;
import com.lianhe.jiudaili.entity.Brand;
import com.lianhe.jiudaili.entity.Company;
import com.lianhe.jiudaili.entity.CompanyBrand;
import com.lianhe.jiudaili.service.BrandService;
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
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CompanyBrandMapper companyBrandMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK", brandMapper.selectList(new QueryWrapper<Brand>()));
    }

    @Override
    public ResultVo selectById(int id) {
        List<Company> coms = new ArrayList<>();
        List<CompanyBrand> companyBrandList = companyBrandMapper.selectList(new QueryWrapper<CompanyBrand>().eq("bid", id));
        for (CompanyBrand companyBrand:companyBrandList) {
            coms.add(companyMapper.selectById(companyBrand.getCid()));
        }
        return ResultUtil.exec(true,"OK",coms);
    }
}
