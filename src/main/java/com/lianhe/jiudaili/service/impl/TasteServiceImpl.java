package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianhe.jiudaili.dao.*;
import com.lianhe.jiudaili.entity.Company;
import com.lianhe.jiudaili.entity.CompanyPrice;
import com.lianhe.jiudaili.entity.CompanyTaste;
import com.lianhe.jiudaili.entity.Taste;
import com.lianhe.jiudaili.service.TasteService;
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
public class TasteServiceImpl extends ServiceImpl<TasteMapper, Taste> implements TasteService {
    @Autowired
    private TasteMapper tasteMapper;
    @Autowired
    private CompanyTasteMapper companyTasteMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK",tasteMapper.selectList(new QueryWrapper<Taste>()));
    }

    @Override
    public ResultVo selectById(int id) {
        List<Company> coms = new ArrayList<>();
        List<CompanyTaste> companyTastes = companyTasteMapper.selectList(new QueryWrapper<CompanyTaste>().eq("bid", id));
        for (CompanyTaste companyTaste:companyTastes) {
            coms.add(companyMapper.selectById(companyTaste.getCid()));
        }
        return ResultUtil.exec(true,"OK",coms);
    }
}
