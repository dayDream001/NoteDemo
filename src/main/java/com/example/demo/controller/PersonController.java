package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {



    @Autowired
    private PersonService personService;

    @RequestMapping("/test")
    public String test(){
        return "Person测试成功!";
    }

    @RequestMapping(value = "/insertPerson", method = RequestMethod.POST)
    public Person insertPerson(Person person) {
        return personService.insertPerson(person);
    }


    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Integer deleteById(String personId) {
        System.out.println(personId);
        int result = personService.deleteById(personId);
        return result;
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ResponseBody
    public String updateById(Person person) {
        System.out.println(person.getPersonId());
        int result = personService.updateById(person);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value ="/getByName" , method = RequestMethod.POST)
    @ResponseBody
    public List<Person> getByName(String personName)  {
        return personService.getByName(personName);
    }

    @RequestMapping("/getPages")
    @ResponseBody
    public int getPages(){
        return personService.getPages();
    }

    //分页--beg
    @RequestMapping(value="/findByPage", method = RequestMethod.POST)
    @ResponseBody
    public List<Person> findByPage(String page){
        Integer page1= Integer.valueOf(page);
        return personService.findByPage(page1);
    }
    @RequestMapping(value = "/count")
    public int count(){
        return personService.count();
    }
    //分页--end

}
