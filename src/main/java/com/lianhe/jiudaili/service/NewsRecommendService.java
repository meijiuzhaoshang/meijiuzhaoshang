package com.lianhe.jiudaili.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.NewsRecommend;
import com.lianhe.jiudaili.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
public interface NewsRecommendService extends IService<NewsRecommend> {
	//查询所有新闻
    ResultVo selectAll();
}
