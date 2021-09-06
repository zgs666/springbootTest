package com.zgs.test.web_demo.controller;

import com.zgs.test.web_demo.entity.CommonResult;
import com.zgs.test.web_demo.entity.User;
import com.zgs.test.web_demo.service.UserService;
import com.zgs.test.web_demo.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/user/get/{id}")
    public CommonResult<User> getUserById(@PathVariable("id")Integer id){
        User user = userService.getUserById(id);
        if (user == null){
            return new CommonResult(ResultCode.Fail.getCode(),ResultCode.Fail.getMsg(),null);
        }else {
            return new CommonResult(ResultCode.Success.getCode(),ResultCode.Success.getMsg(),user);
        }
    }

    @GetMapping(value = "/user/getAll")
    public CommonResult<User> getAllUser(){
        try{
            List<User> userList = userService.getAllUser();
            return new CommonResult(ResultCode.Success.getCode(),ResultCode.Success.getMsg(),userList);
        }catch (Exception e){
            log.error("#############controller异常##################",e);
            return new CommonResult(ResultCode.Fail.getCode(),ResultCode.Fail.getMsg(),e.getMessage());
        }
    }
}
