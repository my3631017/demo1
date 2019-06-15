package com.example.demo1.controller;

import com.example.demo1.dao.UserMapper;
import com.example.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
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
    public User selectUserById(@RequestParam("id") Integer id) {
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
