package com.lianhe.jiudaili.utils;


import com.lianhe.jiudaili.sysconst.SystemCon;
import com.lianhe.jiudaili.vo.ResultVo;

public class ResultUtil {
    public static ResultVo exec(boolean istrue, String msg, Object data) {
        ResultVo resultVo = new ResultVo();
        if (istrue) {
            resultVo.setCode(SystemCon.OK);
        } else {
            resultVo.setCode(SystemCon.ERROR);
        }
        resultVo.setMsg(msg);
        resultVo.setData(data);
        return resultVo;
    }
    public static ResultVo setOK(){
        return exec(true,"OK",null);
    }
    public static ResultVo setERROR(){
        return exec(false,"ERROR",null);
    }
    public static ResultVo setOK(String msg){
        return exec(true,msg,null);
    }
}
