package com.example.demo1.service.impl;

import com.example.demo1.dao.UserMapper;
import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-03-26 18:27
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public Boolean updateUser() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setUsername("pobing");
        user.setAge(22);
        user.setDescription("555");
        user.setHeight("555");
        userList.add(user);

        user = new User();
        user.setId(2);
        user.setUsername("xunxingzhe");
        user.setAge(22);
        user.setDescription("555");
        user.setHeight("555");
        userList.add(user);

        user = new User();
        user.setId(3);
        user.setUsername("gelei");
        user.setAge(22);
        user.setDescription("555");
        user.setHeight("555");
        userList.add(user);
        System.out.println(userList);
        Boolean update = userMapper.update(userList);
        System.out.println(update);
        return update;
    }
}
