package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.NavigationBarMapper;
import com.lianhe.jiudaili.entity.NavigationBar;
import com.lianhe.jiudaili.service.NavigationBarService;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.NavigationBarVo;
import com.lianhe.jiudaili.vo.ResultVo;
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
public class NavigationBarServiceImpl extends ServiceImpl<NavigationBarMapper, NavigationBar> implements NavigationBarService {

    @Autowired
    private NavigationBarMapper navigationBarMapper;

    @Override
    public ResultVo selectAll() {

        List<NavigationBarVo> navigationBarVos = new ArrayList<>();

        QueryWrapper<NavigationBar> queryWrapper1 = new QueryWrapper<>();

        List<NavigationBar> navigationBars = navigationBarMapper.selectList(queryWrapper1);
        for (NavigationBar navigationBar : navigationBars) {
            if (navigationBar.getPid() == null) {
                NavigationBarVo navigationBarVo = new NavigationBarVo();
                QueryWrapper<NavigationBar> queryWrapper2 = new QueryWrapper<NavigationBar>().eq("pid", navigationBar.getId());
                List<NavigationBar> navigationBars1 = navigationBarMapper.selectList(queryWrapper2);
                navigationBarVo.setId(navigationBar.getId());
                navigationBarVo.setTitle(navigationBar.getTitle());
                navigationBarVo.setTitleUrl(navigationBar.getTitleUrl());
                navigationBarVo.setChildNavs(navigationBars1);
                navigationBarVos.add(navigationBarVo);
            }
        }
        return ResultUtil.exec(true, "查询成功", navigationBarVos);
    }
}
