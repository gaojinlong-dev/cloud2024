package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: FeignConfig
 * Package: com.atguigu.cloud.config
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/8 13:34
 * @Version 1.0
 */
@Configuration
public class FeignConfig
{
    @Bean
    public Retryer myRetryer() {

        return Retryer.NEVER_RETRY; //Feign默认配置是不走重试策略的

        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
//        return new Retryer.Default(100,1,3);
    }


    // Feign的日志级别配置
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


}

