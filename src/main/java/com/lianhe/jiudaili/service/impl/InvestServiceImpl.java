package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianhe.jiudaili.dao.CompanyInvestMapper;
import com.lianhe.jiudaili.dao.CompanyMapper;
import com.lianhe.jiudaili.entity.Company;
import com.lianhe.jiudaili.entity.CompanyBrand;
import com.lianhe.jiudaili.entity.CompanyInvest;
import com.lianhe.jiudaili.entity.Invest;
import com.lianhe.jiudaili.dao.InvestMapper;
import com.lianhe.jiudaili.service.InvestService;
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
public class InvestServiceImpl extends ServiceImpl<InvestMapper, Invest> implements InvestService {
    @Autowired
    private InvestMapper investMapper;
    @Autowired
    private CompanyInvestMapper companyInvestMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK",investMapper.selectList(new QueryWrapper<Invest>()));
    }

    @Override
    public ResultVo selectById(int id) {
        List<Company> coms = new ArrayList<>();
        List<CompanyInvest> companyInvests = companyInvestMapper.selectList(new QueryWrapper<CompanyInvest>().eq("lid", id));
        for (CompanyInvest companyInvest:companyInvests) {
            coms.add(companyMapper.selectById(companyInvest.getCid()));
        }
        return ResultUtil.exec(true,"OK",coms);
    }
}
