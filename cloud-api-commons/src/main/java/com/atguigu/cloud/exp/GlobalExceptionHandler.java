package com.atguigu.cloud.exp;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.atguigu.cloud.exp
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/3 15:52
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice // 全局异常处理
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception( Exception e) {
        System.out.println("全局异常处理 in GlobalExceptionHandler");
        log.error("全局异常处理{}",e.getMessage(),e);
         return  ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
