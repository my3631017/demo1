package com.example.demo1.controller;

import com.example.demo1.dao.UserMapper;
import com.example.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-10-30 10:57
 * @version: 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user/add")
    public User insertUser(User user) {
        Long l=userMapper.insertUser(user);
        System.out.println(l);
        return user;
    }

    @GetMapping("/user/query")
    public User selectUserById(Integer id) {
        Optional<User> userOptional = Optional.ofNullable(userMapper.selectUserById(id));
//        return userMapper.selectUserById(id);
//        return userOptional.isPresent();
        return userMapper.selectUserById(id);
    }
}
