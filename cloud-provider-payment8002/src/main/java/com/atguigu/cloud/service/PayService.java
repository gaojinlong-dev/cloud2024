package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * ClassName: PayService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/1 18:15
 * @Version 1.0
 */
public interface PayService {
    //添加支付信息
    public  int  add(Pay pay);

    public int delete( Integer id);
    public int update(Pay pay);
    public Pay getById(Integer id);

    public List<Pay> getAll();



}
