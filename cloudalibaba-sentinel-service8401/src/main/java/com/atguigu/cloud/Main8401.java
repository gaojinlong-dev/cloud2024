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
@EnableDiscoveryClient
@SpringBootApplication
public class Main8401 {
    public static void main(String[] args) {

        SpringApplication.run(Main8401.class,args);
    }
}