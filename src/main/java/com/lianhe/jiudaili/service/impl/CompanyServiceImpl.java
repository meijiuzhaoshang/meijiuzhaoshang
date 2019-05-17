package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianhe.jiudaili.entity.Company;
import com.lianhe.jiudaili.dao.CompanyMapper;
import com.lianhe.jiudaili.service.CompanyService;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Autowired
    private CompanyMapper  companyMapper;

    @Override
    public ResultVo selectAll(){
        return ResultUtil.exec(true,"OK",companyMapper.selectList(new QueryWrapper<Company>()));
    }

    @Override
    public ResultVo selectById(int id) {
        return ResultUtil.exec(true,"OK",companyMapper.selectById(id));
    }
}
