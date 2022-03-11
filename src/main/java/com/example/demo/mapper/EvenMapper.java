package com.example.demo.mapper;

import com.example.demo.entity.Even;
import com.example.demo.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenMapper {

    public int insertEven(Even even);
    public int deleteById(String evenId);
    public int updateById(Even even);
    public List<Even> getByName(String evenName);
    public int getPages();
    //分页--beg
    public List<Even> findByPage(Even even);
    public int count();
    //分页--end
}
