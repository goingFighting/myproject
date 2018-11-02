package com.elitesland.userdemo.controller;

import com.elitesland.userdemo.entity.ResponseResult;
import com.elitesland.userdemo.entity.User;
import com.elitesland.userdemo.service.IUserService;
import com.elitesland.userdemo.service.ex.UsernameConflictException;
import com.elitesland.userdemo.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //***注册页面***
    @GetMapping("/reg")
    public String showReg(){
        return "reg_user";
    }

    //***登录页面***
    @GetMapping("/login")
    public String showLogin(){
        return "login_user";
    }

    @PostMapping("/handle_reg")
    @ResponseBody
    public ResponseResult<String> handleReg(
            @RequestParam("username") String username,
            @RequestParam("IDnum") String IDnum,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("birthday") String birthday,
            @RequestParam("age") Integer age){

        System.out.println("username:"+username);
        System.out.println("IDnum:"+IDnum);
        System.out.println("age:"+age);
        // 声明返回值
        ResponseResult<String> rr;
        // 验证数据的有效性，即基本格式
        boolean result = Validator.checkUsername(username);
        if(!result){
            rr = new ResponseResult<String>(
                    ResponseResult.STATE_ERR,"您输入的用户名有误！");
            return rr;
        }

        result = Validator.checkIDnum(IDnum);
        if(!result){
            rr = new ResponseResult<String>(
                    ResponseResult.STATE_ERR,"您输入的身份证号格式有误！");
            return rr;
        }

        //继续验证手机号，邮箱，年龄（此处省略……）

        try {
            // 把各参数封装到User对象中
            User user = new User(username,IDnum,phone,email,birthday,age);
            userService.reg(user);
            rr = new ResponseResult<String>(ResponseResult.STATE_OK);
        }catch (UsernameConflictException e){
            rr = new ResponseResult<String>(e);
        }
        return rr;
    }



}
