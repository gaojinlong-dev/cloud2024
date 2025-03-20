package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: ${NAME}
 * Package: com.atguigu.cloud
 * Description:
 *
 * @Author 高金龙
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现注册与发现的客户端功能
public class Main9528 {
    public static void main(String[] args)
    {
        SpringApplication.run(Main9528.class,args);
    }
}