package com.example.demo.controller;

import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;
import com.example.demo.util.JwtUtils;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    JwtUtils jwtUtils;
    @RequestMapping( value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map<String ,String> loginMap){
        String userName=loginMap.get("account");
        String password=loginMap.get("password");
        Login login= loginService.login(userName);
        if(login==null||!login.getPasswordHash().equals(password)){
            System.out.println("登录失败!");
            return "error";
        }else{
            Map<String, Object> dataMap = new HashMap<>();
            //生成token并存入数据返回
            String token = jwtUtils.createJwt(login.getPasswordHash(), login.getUserName(), dataMap);
            return token;
        }
    }


}
