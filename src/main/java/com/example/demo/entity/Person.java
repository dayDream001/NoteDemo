package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class Person {
    private String personId;//编号
    private String personName;//名称
    private String personRole;//人物角色
    private String personSex;//人物性别
    private String personAge;//人物年龄
    private String personRace;//人物种族
    private String personJob;//人物职业
    private String personTeam;//人物所属组织关联字段
    private String personLook;//人物外貌关联字段
    private String personSociety;//人物社会关系关联字段
    private String personFamily;//人物家庭关联字段
    private String personEven;//人物事件关联字段
    private String personAbility;//人物能力关联字段
    private String personDisposition;//人物性格关联字段
    private String personLev;//人物等级（重要，龙套）

}
