package com.lianhe.jiudaili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianhe.jiudaili.entity.Message;
import com.lianhe.jiudaili.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-18
 */
public interface MessageService extends IService<Message> {
	//发布信息
    ResultVo insert(Message message, List<MultipartFile> files);
    //根据信息类型查看发布的信息
    ResultVo selectById(int id);
    //查看所有发布的信息
    ResultVo selectAll();
}
