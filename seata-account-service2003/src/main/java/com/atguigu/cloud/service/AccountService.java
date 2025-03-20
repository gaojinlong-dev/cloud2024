package com.atguigu.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * ClassName: AccountService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/20 10:00
 * @Version 1.0
 */
public interface AccountService {
    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money) ;

}