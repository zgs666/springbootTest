package com.zgs.test.web_demo.service.user;

import com.zgs.test.web_demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User getUserById(@Param("id")Integer id);
    List<User> getAllUser();
    Integer addUser(User user);
}