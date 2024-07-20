package com.science.util;


import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @param <T>
 */
@Data
public class JsonResult<T> implements Serializable {

    private Integer state; //编码：1成功，0和其它数字为失败
    private String message; //错误信息
    private T data; //数据

    public JsonResult(Integer state) {
        this.state = state;
    }
    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }
    public JsonResult(Throwable e){
        this.message=e.getMessage();
    }
}
