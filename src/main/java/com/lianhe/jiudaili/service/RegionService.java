package com.lianhe.jiudaili.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.Region;
import com.lianhe.jiudaili.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
public interface RegionService extends IService<Region> {
    //展示所有地区信息
    ResultVo selectAll();
    //展示二级地区信息
    ResultVo selectAllSecondRegion();
    //根据指定地区id展示公司
    ResultVo selectComById(int id);
}
