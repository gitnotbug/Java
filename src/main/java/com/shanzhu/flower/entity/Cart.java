package com.shanzhu.flower.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Cart {

    private int id;
    private int fid;
    private String flower;
    private int amount;
    private float price;
    private int uid;
    private String account;
}


