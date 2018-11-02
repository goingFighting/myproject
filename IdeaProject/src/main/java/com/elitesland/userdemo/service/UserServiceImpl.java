package com.elitesland.userdemo.service;

import com.elitesland.userdemo.dao.UserMapper;
import com.elitesland.userdemo.entity.User;
import com.elitesland.userdemo.service.ex.UsernameConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User reg(User user) {

        User result = findUserByUsername(user.getUsername());
        if(result == null){
            Date now = new Date();
            user.setCreatedUser(user.getUsername());
            user.setCreatedTime(now);
            user.setModifiedUser(user.getUsername());
            user.setModifiedTime(now);
            userMapper.insert(user);
            return user;
        }else{
            throw new UsernameConflictException("用户名" + user.getUsername() + "已被注册");
        }

    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
