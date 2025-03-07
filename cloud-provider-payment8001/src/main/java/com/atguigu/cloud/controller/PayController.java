package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: PayController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/1 19:48
 * @Version 1.0
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
     private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
     public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("添加成功" + i);
    }

    @DeleteMapping(value = "/pay/del{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay( @PathVariable("id") Integer id ){
        int delete = payService.delete(id);
        return ResultData.success(delete);
    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public  ResultData<String> upDatePay( @RequestBody PayDTO payDTO ){
        Pay pay = new Pay();
        //将DTO中的数据拷贝到pay对象中
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.update(pay);
        return ResultData.success("更新成功" + update);
    }
    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public  ResultData<Pay> getById( @PathVariable("id") Integer id ) {

        if (id == -4) throw new RuntimeException("id不能为负数");
        // 模拟延迟62秒,测试fegin的默认调用超时时间
        try {
            TimeUnit.SECONDS.sleep(62);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Pay byId = payService.getById(id);
        return ResultData.success(byId);

    }

        // 全部查询getall
    @GetMapping("pay/getall")
    @Operation(summary = "查所有流水",description = "查询所有支付流水方法")
    public ResultData<List<Pay>>  getall(){
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }


    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String info){

        return "atguiguInfo:"+ info + "port:"+ port;
    }
}
