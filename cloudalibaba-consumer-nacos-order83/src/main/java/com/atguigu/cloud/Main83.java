package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: ${NAME}
 * Package: com.atguigu.cloud
 * Description:
 *
 * @Author 高金龙
 * @Create  2025-03-25 16:48
 * @Version 1.0
 */
@EnableDiscoveryClient // 开启服务发现
@SpringBootApplication
@EnableFeignClients // 开启Feign客户端
public class Main83 {
    public static void main(String[] args) {
        SpringApplication.run(Main83.class,args);
    }
}