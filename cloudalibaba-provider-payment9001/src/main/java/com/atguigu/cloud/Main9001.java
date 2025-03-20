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
@EnableDiscoveryClient //开启服务发现
public class Main9001 {
    public static void main(String[] args) {
        SpringApplication.run(Main9001.class,args);
    }
}