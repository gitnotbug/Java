package com.shanzhu.flower.controller;

import com.shanzhu.flower.config.HttpMsg;
import com.shanzhu.flower.dao.LoginDao;
import com.shanzhu.flower.entity.LoginForm;
import com.shanzhu.flower.entity.R;
import com.shanzhu.flower.entity.User;
import com.shanzhu.flower.util.VerifyUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 用户登录 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-24
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginDao loginDao;

    @RequestMapping("/doLogin")
    R doLogin(@RequestBody LoginForm form) {
        R r = new R();
        if (!VerifyUtil.verifyLoginForm(form)) {
            return r.setCode(4000).setMsg(HttpMsg.ERROR_INPUT);
        }
        User loginUser = loginDao.login(form);
        if (loginUser != null) {
            return r.setCode(2000).setMsg("欢迎您：" + loginUser.getName()).setData(loginUser);
        }
        return r.setCode(4000).setMsg(HttpMsg.ERROR_VERIFY);
    }

}
