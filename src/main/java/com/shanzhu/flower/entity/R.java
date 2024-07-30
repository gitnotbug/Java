package com.shanzhu.flower.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data //自动生成get set tostring等其他方法 非常强大
@Accessors(chain = true) //将set的return为类本身，可以链式赋值 很强大的注解
public class R {
    private int code;
    private String msg;
    private Object data;

}



