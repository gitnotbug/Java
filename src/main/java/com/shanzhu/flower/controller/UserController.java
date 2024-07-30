package com.shanzhu.flower.controller;

import com.shanzhu.flower.config.Constant;
import com.shanzhu.flower.config.HttpMsg;
import com.shanzhu.flower.entity.R;
import com.shanzhu.flower.entity.User;
import com.shanzhu.flower.service.UserService;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-24
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/queryInfoByAccount")
    R queryInfoByAccount(@RequestParam("account") String account) {
        R r = new R();
        if (StringUtil.isEmpty(account)){
            return r.setCode(4000).setMsg(HttpMsg.INVALID_PARAM);
        }
        User loginUser = userService.queryInfo(account);
        if (loginUser == null){
            return r.setCode(4000).setMsg(HttpMsg.INVALID_USER);
        }
        return r.setCode(2000).setData(loginUser);
    }

    @RequestMapping("/find")
    R find(@RequestParam("page") int page, @RequestParam("searchKey") String searchKey) {
        R r = new R();
        Map<String, Object> map = new HashMap<>();
        List<User> users = userService.find(searchKey);
        if (users == null) {
            return r.setCode(2000);
        }
        List<User> items = users.size() >= page * Constant.PAGE_SIZE ?
                users.subList((page - 1) * Constant.PAGE_SIZE, page * Constant.PAGE_SIZE)
                : users.subList((page - 1) * Constant.PAGE_SIZE, users.size());
        int len = users.size() % Constant.PAGE_SIZE == 0 ? users.size() / Constant.PAGE_SIZE
                : (users.size() / Constant.PAGE_SIZE + 1);
        map.put("items", items);
        map.put("len", len);
        return r.setCode(2000).setData(map);
    }

    @RequestMapping("/create")
    R create(@RequestBody User user) {
        R r = new R();
        int ans = userService.add(user);
        if (ans == 1) {
            return r.setCode(2000).setMsg(HttpMsg.ADD_USER_OK);
        }
        return r.setCode(4000).setMsg(HttpMsg.ADD_USER_FAILED);
    }

    @RequestMapping("/update")
    R update(@RequestBody User user) {
        R r = new R();
        int ans = userService.update(user);
        if (ans >= 0) {
            return r.setCode(2000).setMsg(HttpMsg.UPDATE_USER_OK);
        }
        return r.setCode(4000).setMsg(HttpMsg.UPDATE_USER_FAILED);
    }

    @DeleteMapping("/delete")
    R delete(@RequestParam("id") int id) {
        R r = new R();
        int ans = userService.delete(id);
        if (ans == 1) {
            return r.setCode(2000).setMsg(HttpMsg.DELETE_USER_OK);
        }
        return r.setCode(4000).setMsg(HttpMsg.DELETE_USER_FAILED);
    }

}

