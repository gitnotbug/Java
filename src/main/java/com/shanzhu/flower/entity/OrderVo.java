package com.shanzhu.flower.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderVo extends Order{

    private String username;
    private String phone;
    private String address;

}



