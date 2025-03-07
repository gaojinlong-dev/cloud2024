package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

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
// 扫描mapper接口所在的包
@MapperScan("com.atguigu.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient
public class Main8002 {
     public static void main(String[] args) {
        SpringApplication.run(Main8002.class, args);
    }
}