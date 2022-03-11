package com.example.demo.service;


import com.example.demo.entity.Person;
import com.example.demo.entity.User;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;
    public Person insertPerson(Person person){
        personMapper.insertPerson(person);
        return person;

    }


    public int deleteById(String personId){
        return personMapper.deleteById(personId);
    }


    public int updateById(Person person){
        return personMapper.updateById(person);
    }

    public List<Person> getByName(String personName) {
        return personMapper.getByName(personName);
    }

    public int getPages(){
        return personMapper.getPages();
    }
    //分页--beg
    public List<Person> findByPage(Integer page){
        return personMapper.findByPage(page);
    }
    public int count(){
        return  personMapper.count();
    }
    //分页--end


}
