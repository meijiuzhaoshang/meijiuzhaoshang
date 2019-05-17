package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.CompanyHomepageMapper;
import com.lianhe.jiudaili.entity.CompanyHomepage;
import com.lianhe.jiudaili.service.CompanyHomepageService;
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
public class CompanyHomepageServiceImpl extends ServiceImpl<CompanyHomepageMapper, CompanyHomepage> implements CompanyHomepageService {
    @Autowired
    private CompanyHomepageMapper companyHomepageMapper;

    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK",companyHomepageMapper.selectList(new QueryWrapper<CompanyHomepage>()));
    }
}
