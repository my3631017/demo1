package com.example.demo1.dao;

import com.example.demo1.entity.User;
import org.springframework.stereotype.Repository;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-10-30 10:58
 * @version: 1.0
 */
@Repository
public interface UserMapper {
    Long insertUser(User user);
    User selectUserById(Integer id);
}
