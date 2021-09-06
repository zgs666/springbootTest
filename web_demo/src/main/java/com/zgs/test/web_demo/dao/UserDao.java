package com.zgs.test.web_demo.dao;

import com.zgs.test.web_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User getUserById(@Param("id")Integer id);
    List<User> getAllUser();
}
