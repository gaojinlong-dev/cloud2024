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
@EnableDiscoveryClient //服务注册和发现
public class Main9527 {
    public static void main(String[] args) {

        SpringApplication.run(Main9527.class,args);
    }
}