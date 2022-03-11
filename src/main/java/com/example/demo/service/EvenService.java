package com.example.demo.service;


import com.example.demo.entity.Even;
import com.example.demo.entity.Person;
import com.example.demo.mapper.EvenMapper;
import com.example.demo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenService {

    @Autowired
    EvenMapper evenMapper;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    private Person person;

    public Even insertEven(Even even){
        //根据客户名称给relNo赋值，如果客户名称查询不到，则对该客户进行预新增
        String relNo =  getRelNo(even.getEvenPerson1());
               relNo += getRelNo(even.getEvenPerson2());
               relNo += getRelNo(even.getEvenPerson3());
               relNo += getRelNo(even.getEvenPerson4());
               relNo += getRelNo(even.getEvenPerson5());
               relNo += getRelNo(even.getEvenPerson6());
               even.setRelNo(relNo);
        evenMapper.insertEven(even);
        return even;

    }


    public int deleteById(String evenId){
        return evenMapper.deleteById(evenId);
    }


    public int updateById(Even even){
        //根据客户名称给relNo赋值，如果客户名称查询不到，则对该客户进行预新增
        String relNo ="";
        relNo=  getRelNo(even.getEvenPerson1());
        relNo += getRelNo(even.getEvenPerson2());
        relNo += getRelNo(even.getEvenPerson3());
        relNo += getRelNo(even.getEvenPerson4());
        relNo += getRelNo(even.getEvenPerson5());
        relNo += getRelNo(even.getEvenPerson6());
        even.setRelNo(relNo);
        return evenMapper.updateById(even);
    }

    public List<Even> getByName(String evenName) {
        return evenMapper.getByName(evenName);
    }

    public int getPages(){
        return evenMapper.getPages();
    }
    //分页--beg
    public List<Even> findByPage(Even even){
        return evenMapper.findByPage(even);
    }
    public int count(){
        return  evenMapper.count();
    }
    //分页--end
    public String getRelNo(String personName){
        String relNo = "";
        String personId = "";
        if(null!=personName &&!"".equals(personName)){
            System.out.println("personName="+personName);
             personId =personMapper.getIdByName(personName);
            if(null ==personId||"".equals(personId)){
                person.setPersonName(personName);
                personMapper.insertPersonByEven(person);
                personId = personMapper.getIdByName(personName);
            }else{
                personId = personMapper.getIdByName(personName);
            }
            relNo = personId+"@";
        }

        return relNo;
    }

}
