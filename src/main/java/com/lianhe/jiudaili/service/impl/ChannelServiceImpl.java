package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.ChannelMapper;
import com.lianhe.jiudaili.dao.CompanyBrandMapper;
import com.lianhe.jiudaili.dao.CompanyChannelMapper;
import com.lianhe.jiudaili.dao.CompanyMapper;
import com.lianhe.jiudaili.entity.Channel;
import com.lianhe.jiudaili.entity.Company;
import com.lianhe.jiudaili.entity.CompanyChannel;
import com.lianhe.jiudaili.service.ChannelService;
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
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements ChannelService {
    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private CompanyChannelMapper companyChannelMapper;
    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK",channelMapper.selectList(new QueryWrapper<Channel>()));
    }

    @Override
    public ResultVo selectById(int id) {
        List<Company> coms = new ArrayList<>();
        List<CompanyChannel> companyChannels = companyChannelMapper.selectList(new QueryWrapper<CompanyChannel>().eq("chid", id));
        for (CompanyChannel companyCh:companyChannels) {
            coms.add(companyMapper.selectById(companyCh.getCid()));
        }
        return null;
    }
}
