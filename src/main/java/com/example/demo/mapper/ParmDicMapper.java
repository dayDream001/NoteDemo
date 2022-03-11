package com.example.demo.mapper;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParmDicMapper {
    public List<String> getOptName(String keyName);
}
