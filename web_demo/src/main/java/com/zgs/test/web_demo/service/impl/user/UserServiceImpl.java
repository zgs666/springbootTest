package com.zgs.test.web_demo.service.impl.user;

import com.alibaba.fastjson.JSON;
import com.zgs.test.web_demo.dao.UserDao;
import com.zgs.test.web_demo.entity.User;
import com.zgs.test.web_demo.service.user.UserService;
import com.zgs.test.web_demo.util.CollUtils;
import com.zgs.test.web_demo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public static final ReentrantLock lock = new ReentrantLock(true);
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private UserDao userDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public User getUserById(Integer id) {
        log.info("############查询id为：[" + id + "]###############");
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            //首先从redis获取数据
            long listLength = redisTemplate.opsForList().size("userList");
            List<String> users = redisTemplate.opsForList().range("userList", 0, listLength);
            String usersString = redisUtil.redisOpsForListSubStr(users.toString());
            //如果redis没获取到数据则数据库读取
            if (usersString.isEmpty()){
                log.info("###################从数据库查询#########################");
                userList = userDao.getAllUser();
                log.info("######JSON.toJSONString:"+JSON.toJSONString(userList)+"########################");
                redisTemplate.opsForList().leftPush("userList", JSON.toJSONString(userList));
            }else {
                log.info("############从redis读取+usersString:"+usersString+"############################");
                userList = JSON.parseArray(usersString,User.class);
            }
            //redis/数据库均无数据
            if (CollUtils.isEmpty(userList)) {
                log.error("###########查询暂无记录###############");
                throw new RuntimeException("查询暂无记录");
            }
            return userList;
        } catch (Exception e) {
            log.error("################e.getMessage():"+e.getMessage()+"#########################");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Integer addUser(User user) {
        try {
            log.info("#######新增user--service层############");
            Integer id = userDao.addUser(user);
            return id;
        }catch (Exception e){
            log.error("###########新增异常#############",e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
