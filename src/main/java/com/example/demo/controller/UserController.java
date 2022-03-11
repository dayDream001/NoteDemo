package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
public class UserController {



    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        return "测试成功!";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Integer delete(String userId) {
        System.out.println(userId);
        int result = userService.delete(userId);
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userService.insertUser(user);
    }

    @RequestMapping("/ListUser")
    @ResponseBody
    public List<User> ListUser() {
        return userService.ListUser();
    }

    @RequestMapping("/getById")
    @ResponseBody
    public User getById(@RequestParam("userId") String userId){
        System.out.println("userId="+userId);
        return userService.getById(userId);
    }

//    @RequestMapping("/ListByName")
//    @ResponseBody
//    public List<User> ListUserByName(@RequestParam("userName") String userName)  {
//        System.out.println("userName="+userName);
//        return userService.findByName(userName);
//    }

    @RequestMapping(value ="/ListByName" , method = RequestMethod.POST)
    @ResponseBody
    public List<User> ListUserByName(String userName)  {
        System.out.println("userName="+userName);
        System.out.println(userService.findByName(userName));
        return userService.findByName(userName);
    }

    /**
     * 分页
     * @return
     */
    @RequestMapping(value="/page")
    @ResponseBody
    public List<User> page(Integer page){
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize*(pageNow-1);
        List<User> list = userService.queryPage(startRows);
        return list;
    }

    /**
     * rows
     * @return
     */
    @RequestMapping(value="/rows")
    @ResponseBody
    public int rows(){
        return userService.getRowCount();
    }



}
