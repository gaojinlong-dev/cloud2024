package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: orderCircuitController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/8 15:43
 * @Version 1.0
 */
@RestController
public class OrderCircuitController {
    @Resource
    private PayFeignApi payFeignApi;

    /**
     * 断路器
     * @param id
     * @return
     */

    @GetMapping(value = "/feign/pay/circuit/{id}")
    //@CircuitBreaker注解用在方法上，表示该方法开启了断路器功能,name属性指定断路器的名称，fallbackMethod属性指定当服务降级时调用的方法。
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String myCircuitBreaker(@PathVariable("id") Integer id)
    {
        return payFeignApi.myCircuit(id);
    }
    //myCircuitFallback就是服务降级后的兜底处理方法
    public String myCircuitFallback(Integer id,Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }


   /* *//**
     *(船的)舱壁,隔离 ,信号量模式
     * @param id
     * @return
     *//*
    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    //Bulkhead注解用在方法上，表示该方法开启了舱壁隔离功能,name属性指定舱壁的名称，fallbackMethod属性指定当服务降级时调用的方法，type属性指定舱壁的类型，默认为SEMAPHORE。
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.SEMAPHORE)
    public String myBulkhead(@PathVariable("id") Integer id)
    {
        return payFeignApi.myBulkhead(id);
    }
    public String myBulkheadFallback(Throwable t)
    {
        return "myBulkheadFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }*/


    /**
     * 舱壁,隔离,线程池模式
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    //Bulkhead注解用在方法上，表示该方法开启了舱壁隔离功能,name属性指定舱壁的名称，fallbackMethod属性指定当服务降级时调用的方法，type属性指定舱壁的类型，默认为SEMAPHORE。
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadPoolFallback",type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> myBulkheadTHREADPOOL(@PathVariable("id") Integer id)
    {
        System.out.println(Thread.currentThread().getName() + "   ----开始进入");
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName() + "   ----准备离开");
        return CompletableFuture.supplyAsync(() -> payFeignApi.myBulkhead(id)+ "Bulkhead.Type.THREADPOOL测试");
    }
    public CompletableFuture<String>  myBulkheadPoolFallback(Integer id, Throwable t)
    {
        return CompletableFuture.supplyAsync(() -> "Bulkhead.Type.THREADPOOL，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }
}
