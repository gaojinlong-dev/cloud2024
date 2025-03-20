package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * ClassName: OrderService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/19 19:54
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}
