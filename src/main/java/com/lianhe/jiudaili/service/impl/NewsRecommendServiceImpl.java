package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.NewsRecommendMapper;
import com.lianhe.jiudaili.entity.NewsRecommend;
import com.lianhe.jiudaili.service.NewsRecommendService;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class NewsRecommendServiceImpl extends ServiceImpl<NewsRecommendMapper, NewsRecommend> implements NewsRecommendService {

    @Autowired
    private NewsRecommendMapper newsRecommendMapper;

    @Override
    public ResultVo selectAll() {

        QueryWrapper<NewsRecommend> queryWrapper = new QueryWrapper<>();

        List<NewsRecommend> newsRecommends = newsRecommendMapper.selectList(queryWrapper);

        return ResultUtil.exec(true, "查询成功", newsRecommends);
    }
}
