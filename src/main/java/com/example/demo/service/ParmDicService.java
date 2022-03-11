package com.example.demo.service;

import com.example.demo.mapper.ParmDicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParmDicService {
    @Autowired
    ParmDicMapper parmDicMapper;
    public List<String> getOptName(String keyName){
        return parmDicMapper.getOptName(keyName);
    }
}
