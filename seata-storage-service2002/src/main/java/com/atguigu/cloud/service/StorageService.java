package com.atguigu.cloud.service;

/**
 * ClassName: StorageService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/20 9:48
 * @Version 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
