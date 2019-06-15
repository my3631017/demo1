package com.example.demo1.dao;

import com.example.demo1.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
 */
@Repository
public interface UserMapper {
    void truncateTable();

    Long insertUser(User user);

    User selectUserById(Integer id);

    List<User> selectAll();

    Boolean update(@Param("list") List<User> userList);
}
