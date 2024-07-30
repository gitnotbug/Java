package com.shanzhu.flower.dao;

import com.shanzhu.flower.entity.LoginForm;
import com.shanzhu.flower.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    @Select("select * from users where account = #{account} and password = #{password} and role = #{role};")
    User login(LoginForm form);

}




