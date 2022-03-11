package com.example.demo.controller;

import com.example.demo.entity.Even;
import com.example.demo.entity.Person;
import com.example.demo.service.EvenService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/even")
public class EvenController {



    @Autowired
    private EvenService evenService;
    @Autowired
    private Even even;

    @RequestMapping("/test")
    public String test(){
        return "Even测试成功!";
    }

    @RequestMapping(value = "/insertEven", method = RequestMethod.POST)
    public Even insertEven(Even even) {
        return evenService.insertEven(even);
    }


    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Integer deleteById(String evenId) {
        System.out.println(evenId);
        int result = evenService.deleteById(evenId);
        return result;
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ResponseBody
    public String updateById(Even even) {
        System.out.println(even.getEvenId());
        int result = evenService.updateById(even);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value ="/getByName" , method = RequestMethod.POST)
    @ResponseBody
    public List<Even> getByName(String evenName)  {
        return evenService.getByName(evenName);
    }

    @RequestMapping("/getPages")
    @ResponseBody
    public int getPages(){
        return evenService.getPages();
    }




    //分页--beg
    @RequestMapping(value="/findByPage", method = RequestMethod.POST)
    @ResponseBody
    public List<Even> findByPage(@RequestBody Map<String ,String> map){
        Integer page1= Integer.valueOf(map.get("page"));
        String relNo = map.get("relNo");
        System.out.println("relNo="+relNo+"page="+page1);
        even.setPage(page1);
        even.setRelNo(relNo);
        return evenService.findByPage(even);
    }
    @RequestMapping(value = "/count")
    public int count(){
        return evenService.count();
    }
    //分页--end

}
