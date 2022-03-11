package com.example.demo.mapper;

import com.example.demo.entity.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    public Login login(String userName);
}
