package com.atguigu.cloud;

import java.time.ZonedDateTime;

/**
 * ClassName: ${NAME}
 * Package: com.atguigu.cloud
 * Description:
 *
 * @Author 高金龙
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
         //获取当前时区
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);//2025-03-11T17:38:58.009435600+08:00[Asia/Shanghai]

    }
}