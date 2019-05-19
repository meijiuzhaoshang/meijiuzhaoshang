package com.lianhe.jiudaili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianhe.jiudaili.dao.MessageMapper;
import com.lianhe.jiudaili.dao.MessageTypeMapper;
import com.lianhe.jiudaili.entity.Message;
import com.lianhe.jiudaili.service.MessageService;
import com.lianhe.jiudaili.utils.RandomUtil;
import com.lianhe.jiudaili.utils.ResultUtil;
import com.lianhe.jiudaili.vo.ResultVo;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-18
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MessageTypeMapper messageTypeMapper;

    @Override
    public ResultVo insert(Message message, List<MultipartFile> files) {
        String newFileName = "";
        String imgPath = "";
        OutputStream out = null;
        InputStream fileInput = null;
        List<String> list = new ArrayList<>();
        try {
            if (files.size() != 0) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String dateStr = sdf.format(new Date());

                // 获取当前工作路径
                String filepath = "/usr/local/tomcat/webapps/jiudailiImg/";

                // 如果目录不存在，创建
                File temFile = new File(filepath);
                if (!temFile.exists()) {
                    temFile.mkdirs();
                }

                int num = RandomUtil.createNum(6);
                for (MultipartFile file : files) {
                    imgPath = "http://47.102.214.131:8081/jiudailiImg/" + dateStr + num + file.getOriginalFilename();
                    file.transferTo(new File(newFileName));
                    list.add(imgPath);
                }
                if (list.size() == 3) {
                    message.setImag1(list.get(0));
                    message.setImage2(list.get(1));
                    message.setImage3(list.get(2));
                } else {
                    return ResultUtil.exec(false, "上传失败", null);
                }
            }
        } catch (Exception e) {
            return ResultUtil.exec(false, "上传失败", e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
                return ResultUtil.exec(false, "上传失败", e.getMessage());
            }
        }
        return ResultUtil.exec(true, "上传成功", messageMapper.insert(message));
    }

    @Override
    public ResultVo selectById(int id) {
        return  ResultUtil.exec(true,"OK",messageMapper.selectList(new QueryWrapper<Message>().eq("tid",id)));
    }

    @Override
    public ResultVo selectAll() {
        return ResultUtil.exec(true,"OK",messageMapper.selectList(new QueryWrapper<Message>()));
    }
}
