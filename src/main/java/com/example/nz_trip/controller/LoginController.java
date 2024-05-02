package com.example.nz_trip.controller;


import com.example.nz_trip.entity.User;
import com.example.nz_trip.mapper.UserMapper;
import com.example.nz_trip.utils.JwtUtil;
import com.example.nz_trip.utils.Result;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

@RestController
public class LoginController {


    @Autowired
    private  UserMapper userMapper;

    @GetMapping("/login")
    public Result login(String username, String password){
        User user = userMapper.findByUsername(username);
        if(user == null){
            return Result.failed().message("用户不存在");
        }
        if(!user.getPassword().equals(password)){
            return Result.failed().message("用户密码不正确");
        }

        String token =  JwtUtil.generateToken(user.getUsername());
        HashMap<String, Object> successRes = new HashMap<>();
        successRes.put("token",token);
        successRes.put("user",user);

        return Result.success().data(successRes);
    }


    @GetMapping("/register")
    public Result register(String username, String password,String phone){
        User user = userMapper.findByUsername(username);
        if(user != null){
            return Result.failed().message("用户已存在");
        }
        Date currentDate = new Date();
        User newUser = new User(username,password,phone,0,currentDate);
        userMapper.insert(newUser);
        return Result.success();
    }

    @GetMapping("/user_info")
    public Result userInfo(HttpServletRequest request, HttpServletResponse response){

        String token =  request.getHeader("Authorization");
        System.out.println(token+"----------------------");
        if (token == null){
            return Result.failed().message("token不能为空");
        }
        Claims claims =  JwtUtil.parseToken(token);
        if (claims == null){
            response.setStatus(401);
            return Result.failed().message("token解析失败");
        }

        User user = userMapper.findByUsername(claims.getSubject());
        if(user == null){
            return Result.failed().message("用户不存在");
        }
        HashMap<String,Object> successRes = new HashMap<>();
        successRes.put("user",user);
        return Result.success().data(successRes);
    }
}
