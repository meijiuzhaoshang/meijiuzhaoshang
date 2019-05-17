package com.lianhe.jiudaili.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.CompanyAreaMapper;
import com.lianhe.jiudaili.dao.CompanyMapper;
import com.lianhe.jiudaili.dao.SubareaMapper;
import com.lianhe.jiudaili.entity.Company;
import com.lianhe.jiudaili.entity.CompanyArea;
import com.lianhe.jiudaili.entity.Subarea;
import com.lianhe.jiudaili.service.SubareaService;
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
public class SubareaServiceImpl extends ServiceImpl<SubareaMapper, Subarea> implements SubareaService {
    @Autowired
    private SubareaMapper subareaMapper;
    @Autowired
    private CompanyAreaMapper companyAreaMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK",subareaMapper.selectList(new QueryWrapper<Subarea>()));
    }

    @Override
    public ResultVo selectById(int id) {
        List<Company> list = new ArrayList<>();
        List<CompanyArea> companyAreas = companyAreaMapper.selectList(new QueryWrapper<CompanyArea>().eq("aid", id));
        for (CompanyArea companyArea: companyAreas) {
            list.add(companyMapper.selectById(companyArea.getCid()));
        }
        return ResultUtil.exec(true,"OK",list);
    }
}
