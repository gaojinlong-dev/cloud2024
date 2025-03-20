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
 * Description: 支付服务接口定义，用于远程调用支付服务的接口
 *
 * @Author 高金龙
 * @Create 2025/3/7 20:27
 * @Version 1.0
 */
//@FeignClient(value = "cloud-payment-service")
@FeignClient(value = "cloud-gateway")
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


    /**
     * Resilience4j Ratelimit 限流 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id);

    /**
     *Micrometer(Sleuth)进行链路监控的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);



    /**
     * GateWay进行网关测试案例01
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();


}
