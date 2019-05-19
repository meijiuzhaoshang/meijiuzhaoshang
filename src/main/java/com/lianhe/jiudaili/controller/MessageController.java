package com.lianhe.jiudaili.controller;

import com.lianhe.jiudaili.entity.Message;
import com.lianhe.jiudaili.service.MessageService;
import com.lianhe.jiudaili.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 酒代理---助攻冯志立
 * @since 2019-05-18
 */
@Api(value = "发布信息相关操作", tags = "发布相关方法")
@RestController
@RequestMapping("/jiudaili/message")
public class MessageController {
	@Autowired
    private MessageService messageService;

    @PostMapping("/add.do")
    @ApiOperation(value = "发布信息")
    public ResultVo add(Message message, HttpServletRequest request){
        message.setCreatetime(new Date());
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        return messageService.insert(message, files);
    }
    @PostMapping("/selectbyid.do")
    @ApiOperation(value = "通过信息类型查看发布信息")
    public ResultVo selectById(int id){
        return messageService.selectById(id);
    }
    @PostMapping("/all.do")
    @ApiOperation(value = "查看所有的发布信息")
    public ResultVo selectAll(){
        return messageService.selectAll();
    }
}
