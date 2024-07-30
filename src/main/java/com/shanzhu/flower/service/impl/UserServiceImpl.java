package com.shanzhu.flower.service.impl;

import com.shanzhu.flower.dao.UserDao;
import com.shanzhu.flower.entity.User;
import com.shanzhu.flower.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userdao;

    @Override
    public int add(User user) {
        try {
            return userdao.add(user);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int delete(int uid) {
        return userdao.delete(uid);
    }

    @Override
    public int update(User user) {
        return userdao.update(user);
    }

    @Override
    public List<User> find(String searchKey) {
        return userdao.find(searchKey);
    }

    @Override
    public User queryInfo(String account) {
        return userdao.queryInfo(account);
    }
}
