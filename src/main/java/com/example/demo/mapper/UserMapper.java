package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    public int  insertUser(User user);
    public int  delete(String userId);
    public int  Update(User user);
    public int  getRowCount();
    public List<User> ListUser();
    public List<User> findUserByName(String userName);
    public List<User> queryPage();
    public User getById(String userId);
}
