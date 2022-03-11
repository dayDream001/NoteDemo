package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class User {
    private String  userId;
    private String userName;
    private String userDate;
    private String userAddress;

}
