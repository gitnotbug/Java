package com.shanzhu.flower.service;

import com.shanzhu.flower.entity.Cart;
import com.shanzhu.flower.entity.Order;

import java.util.List;

/**
 * 订单 服务层
 *
 * @author: ShanZhu
 * @date: 2024-01-24
 */
public interface OrderService {

    int add(Cart cart);
    int delete(int uid);
    int update(Order order);
    List<Order> find(String searchKey, String account);
    List<Order> findAll(String searchKey);
    List<Order> queryByAccount(String account);
}
