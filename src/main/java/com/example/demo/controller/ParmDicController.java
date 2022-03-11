package com.example.demo.controller;

import com.example.demo.service.ParmDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dic")
public class ParmDicController {
    @Autowired
    private ParmDicService parmDicService;

    @RequestMapping(value = "/getOptName",method = RequestMethod.POST)
    @ResponseBody
    public List<String> getOptName(String keyName){
        return parmDicService.getOptName(keyName);
    }
}
