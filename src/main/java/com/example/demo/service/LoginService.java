package com.example.demo.service;

import com.example.demo.entity.Login;
import com.example.demo.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;
    public Login login(String userName){
        return loginMapper.login(userName);
    }
}
