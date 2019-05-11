package com.lianhe.jiudaili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.DrinksAdvertisement;
import com.lianhe.jiudaili.vo.ResultVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
public interface DrinksAdvertisementService extends IService<DrinksAdvertisement> {
	//展示所有的酒水广告
    ResultVo selectAll();
}
