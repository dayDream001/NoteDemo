package com.example.demo.mapper;

import com.example.demo.entity.Person;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper {

    public int insertPerson(Person person);
    public int insertPersonByEven(Person person);
    public int deleteById(String personId);
    public int updateById(Person person);
    public List<Person> getByName(String personName);
    public int getPages();
    public String getIdByName(String personName);
    //分页--beg
    public List<Person> findByPage(Integer page);
    public int count();
    //分页--end
}
