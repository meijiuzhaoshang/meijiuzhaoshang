package com.lianhe.jiudaili.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.RegionMapper;
import com.lianhe.jiudaili.entity.Region;
import com.lianhe.jiudaili.service.RegionService;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.RegionVo;
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
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public ResultVo selectAll() {
        List<RegionVo> regionVos = new ArrayList<>();

        QueryWrapper<Region> queryWrapper1 = new QueryWrapper<>();

        List<Region> regions = regionMapper.selectList(queryWrapper1);
        for (Region region : regions) {
            if (region.getPid() == null) {
                RegionVo regionVo = new RegionVo();
                QueryWrapper<Region> queryWrapper2 = new QueryWrapper<Region>().eq("pid", region.getId());
                List<Region> regions1 = regionMapper.selectList(queryWrapper2);
                regionVo.setId(region.getId());
                regionVo.setRegion(region.getRegion());
                regionVo.setRegionUrl(region.getRegionUrl());
                regionVo.setChildRegions(regions1);
                regionVos.add(regionVo);
            }
        }
        return ResultUtil.exec(true, "查询成功", regionVos);
    }

    @Override
    public ResultVo selectAllSecondRegion() {
        QueryWrapper<Region> queryWrapper = new QueryWrapper<>();
        List<Region> regions = regionMapper.selectList(queryWrapper);
        List<Region> secondRegions = new ArrayList<>();
        for (Region region : regions) {
            if (region.getPid() != null) {
                secondRegions.add(region);
            }
        }
        return ResultUtil.exec(true, "查询成功", secondRegions);
    }
}
