package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class ParmDic {
    private String  keyName;
    private String  optCode;
    private String  optName;
    private int  seqn;
    private String  sts;
}
