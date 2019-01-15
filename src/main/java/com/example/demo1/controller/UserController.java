package com.example.demo1.controller;

import com.example.demo1.dao.UserMapper;
import com.example.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-10-30 10:57
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/truncate")
    public String truncateTable() {
        userMapper.truncateTable();
        return "表格已清空";
    }

    @PostMapping("/add")
    public User insertUser(@RequestBody User user) {
        Long l = userMapper.insertUser(user);
        System.out.println(l);
        return user;
    }

    @GetMapping("/query")
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @GetMapping("/all")
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
        users.forEach(r -> System.out.println(r.getUsername()));
        return users;
    }
}
