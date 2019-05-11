package com.lianhe.jiudaili.testmain;

import com.lianhe.jiudaili.utils.AliyunSmsUtil;
import com.lianhe.jiudaili.utils.RandomUtil;

public class AliyunSmsTest {
    public static void main(String[] args) {
        int code=RandomUtil.createNum(6);
        System.out.println(AliyunSmsUtil.sendSms("15290253173",code));
    }
}
