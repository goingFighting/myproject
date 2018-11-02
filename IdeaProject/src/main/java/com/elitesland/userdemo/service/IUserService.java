package com.elitesland.userdemo.service;

import com.elitesland.userdemo.entity.User;

public interface IUserService {

    /**
     * 用户注册
     * @param user 用户对象
     * @return 用户对象
     * @author allen
     */
    User reg(User user);

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 用户信息
     * @author allen
     */
    User findUserByUsername(String username);




}
