package com.lianhe.jiudaili.config;

import com.lianhe.jiudaili.sysconst.SystemCon;
import com.lianhe.jiudaili.utils.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author gong
 * @Date Created in 2019/3/19 14:42
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisUtil createJ() {
        return new JedisUtil(SystemCon.REDISHOST, SystemCon.REDISPORT, SystemCon.REDISPASS);
    }
}
