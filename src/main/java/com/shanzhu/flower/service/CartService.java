package com.shanzhu.flower.service;

import com.shanzhu.flower.entity.Cart;

import java.util.List;

/**
 * 购物车 服务
 *
 * @author: ShanZhu
 * @date: 2024-01-24
 */
public interface CartService {
    //添加一个findall函数实现查询所有用户
    // 添加购物车
    int add(Cart cart);
    // 删除购物车
    int delete(int uid);
    // 更新购物车
    int update(Cart cart);
    // 根据搜索关键字和账号查询购物车
    List<Cart> find(String searchKey,String account);
    // 根据账号查询购物车
    List<Cart> queryByAccount(String account);
}
