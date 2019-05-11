package com.lianhe.jiudaili.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.DrinksAdvertisementImgsMapper;
import com.lianhe.jiudaili.dao.DrinksAdvertisementMapper;
import com.lianhe.jiudaili.entity.DrinksAdvertisement;
import com.lianhe.jiudaili.entity.DrinksAdvertisementImgs;
import com.lianhe.jiudaili.service.DrinksAdvertisementService;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.DrinksAdvertisementVo;
import com.lianhe.jiudaili.vo.ResultVo;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@Service
public class DrinksAdvertisementServiceImpl extends ServiceImpl<DrinksAdvertisementMapper, DrinksAdvertisement> implements DrinksAdvertisementService {

    @Autowired
    private DrinksAdvertisementMapper drinksAdvertisementMapper;

    @Autowired
    private DrinksAdvertisementImgsMapper drinksAdvertisementImgsMapper;

    @Override
    public ResultVo selectAll() {

        List<DrinksAdvertisementVo> drinksAdvertisementVos = new ArrayList<>();


        QueryWrapper<DrinksAdvertisement> queryWrapper1 = new QueryWrapper<>();
        List<DrinksAdvertisement> drinksAdvertisements = drinksAdvertisementMapper.selectList(queryWrapper1);
        for (DrinksAdvertisement drinksAdvertisement : drinksAdvertisements) {
            DrinksAdvertisementVo drinksAdvertisementVo = new DrinksAdvertisementVo();
            QueryWrapper<DrinksAdvertisementImgs> queryWrapper2 = new QueryWrapper<DrinksAdvertisementImgs>().eq("drinks_advertisement_id", drinksAdvertisement.getId());
            List<DrinksAdvertisementImgs> drinksAdvertisementImgs = drinksAdvertisementImgsMapper.selectList(queryWrapper2);

            drinksAdvertisementVo.setId(drinksAdvertisement.getId());
            drinksAdvertisementVo.setManufacturersId(drinksAdvertisement.getManufacturersId());
            drinksAdvertisementVo.setManufacturersUrl(drinksAdvertisement.getManufacturersUrl());
            drinksAdvertisementVo.setDrinksAdvertisementImgs(drinksAdvertisementImgs);

            drinksAdvertisementVos.add(drinksAdvertisementVo);
        }

        return ResultUtil.exec(true, "查询成功", drinksAdvertisementVos);
    }
}
