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

   /* public static void main(String[] args) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for (int i = 0; i < 10000; i++) {
            String shijie = createToken(2, "shijie");
            if (shijie.contains("/")) {
                System.out.println("有/");
                c1 += 1;
            }
            //System.out.println(shijie);
            TokenVO tokenVO = parseToken(shijie);
            if (tokenVO.getUid() != 2) {
                System.out.println("!=2");
                c2 += 1;
            }
            if (!tokenVO.getContent().equals("shijie")) {
                System.out.println("!=shijie");
                c3 += 1;
            }

            //System.out.println(tokenVO.getUid());
            //System.out.println(tokenVO.getContent());
            //System.out.println(tokenVO.getDate());
            //System.out.println(tokenVO.getRandom());
        }
        if (c1 == 0 && c2 == 0 && c3 == 0) {
            System.out.println("ok");
        }
    }*/
    public static void main(String[] args) {
        String shijie = createToken(2, "shijie");
        System.out.println(shijie);
        TokenVO tokenVO = parseToken(shijie);
        System.out.println(tokenVO.getUid());
        System.out.println(tokenVO.getContent());
        System.out.println(tokenVO.getDate());
        System.out.println(tokenVO.getRandom());
    }
}
