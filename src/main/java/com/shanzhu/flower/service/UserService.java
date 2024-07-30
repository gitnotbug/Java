package com.shanzhu.flower.service;

import com.shanzhu.flower.entity.User;

import java.util.List;

/**
 * 用户 服务层
 *
 * @author: ShanZhu
 * @date: 2024-01-24
 */
public interface UserService {

    int add(User user);
    int delete(int uid);
    int update(User user);
    List<User> find(String searchKey);
    User queryInfo(String account);
}
