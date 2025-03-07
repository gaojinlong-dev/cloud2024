package com.atguigu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName: ResultData
 * Package: com.atguigu.cloud.resp
 * Description:
 *
 * @Author 高金龙
 * @Create 2025/3/3 15:15
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class ResultData <T>{
    // 状态码
    private String code;/** 结果状态 ,具体状态码参见枚举类ReturnCodeEnum.java*/
    // 状态信息
    private String msg;
    // 返回数据
    private T data;
    // 时间戳
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        ResultData result = new ResultData();
        result.setCode(ReturnCodeEnum.RC200.getCode());
        result.setMsg(ReturnCodeEnum.RC200.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> ResultData<T> fail(String code, String msg) {
        ResultData result = new ResultData();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
