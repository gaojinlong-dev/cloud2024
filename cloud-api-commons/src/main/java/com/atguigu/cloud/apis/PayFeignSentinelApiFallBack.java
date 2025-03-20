package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * ClassName: PayFeignSentinelApiFallBack
 * Package: com.atguigu.cloud.apis
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/18 10:28
 * @Version 1.0
 */
@Component
public class PayFeignSentinelApiFallBack  implements PayFeignSentinelApi {


    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
