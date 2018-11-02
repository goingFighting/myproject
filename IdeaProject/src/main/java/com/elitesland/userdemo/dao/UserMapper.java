package com.elitesland.userdemo.dao;

import com.elitesland.userdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 添加用户信息
     * @param user 用户对象
     * @return 受影响的行数
     * @author allen
     */
    Integer insert(User user);

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 用户信息
     * @author allen
     */
    User findUserByUsername(String username);



}
