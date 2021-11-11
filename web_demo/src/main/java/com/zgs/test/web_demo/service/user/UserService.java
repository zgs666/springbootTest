package com.zgs.test.web_demo.service.user;

import com.zgs.test.web_demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zgs
* @date 2021/11/11 16:36
*/
public interface UserService {
    /**
     * 获取用户信息
    * @author zgs
    * @date 2021/11/11 16:35
    * @return User
     * @param id 用户id
    */
    User getUserById(@Param("id")Integer id);
    /**
     * 获取所有用户信息
    * @author zgs
    * @date 2021/11/11 16:35
    * @return User
    */
    List<User> getAllUser();
    /**
     * 新增用户
    * @author zgs
    * @date 2021/11/11 16:36
     * @param user	用户实体
    */
    Integer addUser(User user);
}
