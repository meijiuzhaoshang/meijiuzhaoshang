package com.lianhe.jiudaili.utils;

import com.alibaba.fastjson.JSON;
import com.lianhe.jiudaili.sysconst.SystemCon;
import com.lianhe.jiudaili.vo.TokenVO;

import java.util.Date;
import java.util.Random;


/**
 * @Author feri
 * @Date Created in 2019/4/29 14:46
 */
public class TokenUtil {
    //生成Token
    public static String createToken(int id, String msg) {
        TokenVO tokenVO = new TokenVO();
        tokenVO.setContent(msg);
        tokenVO.setUid(id);
        tokenVO.setDate(new Date());
        tokenVO.setRandom(new Random().nextLong());
        String str = JSON.toJSONString(tokenVO);

        return EncryptionUtil.AESEnc(SystemCon.TOKENKEY, str);
    }

    //解析Token
    public static TokenVO parseToken(String msg) {
        String json = EncryptionUtil.AESDec(SystemCon.TOKENKEY, msg);
        return JSON.parseObject(json, TokenVO.class);
    }

    //更新Token
    public static String updateToken(String token) {
        String json = EncryptionUtil.AESDec(SystemCon.TOKENKEY, token);
        TokenVO tokenVO = JSON.parseObject(json, TokenVO.class);
        tokenVO.setDate(new Date());
        tokenVO.setRandom(new Random().nextLong());
        return EncryptionUtil.AESEnc(SystemCon.TOKENKEY, JSON.toJSONString(tokenVO));
    }

}
