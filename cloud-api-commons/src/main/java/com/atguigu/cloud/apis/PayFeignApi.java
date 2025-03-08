package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName: PayFeignApi
 * Package: com.atguigu.cloud.apis
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/7 20:27
 * @Version 1.0
 */
@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {


    // 8001 服务提供者中的PayController 提供的接口

    /**
     * 新增一条支付相关流水记录
     * @param payDTO
     * @return
     */
    @GetMapping(value = "/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    /**
     * 根据id查询支付相关流水记录
     * @param id
     * @return
     */

    @GetMapping(value = "/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable ("id") Integer id);

    /**
     * 测试负载均衡， openfeign天然支持负载均衡演示
     * @return
     */
    @GetMapping(value = "/pay/get/info")
    public String mylb();

    /**
     * Resilience4j CircuitBreaker 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);


    /**
     * Resilience4j Bulkhead 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);


}
