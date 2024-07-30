package com.shanzhu.flower.service.impl;

import com.shanzhu.flower.dao.CartDao;
import com.shanzhu.flower.dao.UserDao;
import com.shanzhu.flower.entity.Cart;
import com.shanzhu.flower.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// 定义一个CartServiceImpl类，实现CartService接口
@Service
public class CartServiceImpl implements CartService {

    // 注入CartDao对象
    @Resource
    private CartDao cartDao;

    // 注入UserDao对象
    @Resource
    private UserDao userDao;

    // 添加购物车
    @Override
    public int add(Cart cart) {
        // 根据用户账号查询用户id
        int uid = userDao.queryIdByAccount(cart.getAccount());
        // 设置购物车所属用户id
        cart.setUid(uid);
        // 查询购物车中是否已存在该商品
        Cart cart1 = cartDao.checkIsAdded(cart);
        // 如果不存在，则添加商品到购物车
        if (cart1==null){
            return cartDao.add(cart);
        // 如果存在，则增加商品数量
        }else {
            return cartDao.addAmount(cart);
        }
    }

    // 删除购物车
    @Override
    public int delete(int uid) {
        // 根据用户id删除购物车
        return cartDao.delete(uid);
    }

    // 更新购物车
    @Override
    public int update(Cart cart) {
        // 根据购物车id更新购物车
        return cartDao.update(cart);
    }

    // 查询购物车
    @Override
    public List<Cart> find(String searchKey,String account) {
        // 根据搜索关键字和用户账号查询购物车
        return cartDao.find(searchKey,account);
    }

    // 根据用户账号查询购物车
    @Override
    public List<Cart> queryByAccount(String account) {
        // 根据用户账号查询用户id
        Integer uid = userDao.queryIdByAccount(account);
        // 根据用户id查询购物车
        return cartDao.queryByUid(uid);
    }
    //添加一个addfil方法


}
//
