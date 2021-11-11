package com.zgs.test.web_demo.controller;

import com.zgs.test.web_demo.entity.CommonResult;
import com.zgs.test.web_demo.entity.User;
import com.zgs.test.web_demo.service.user.UserService;
import com.zgs.test.web_demo.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("根据id查询用户")
    @GetMapping(value = "/get/{id}")
    public CommonResult<User> getUserById(@PathVariable("id")Integer id){
        User user = userService.getUserById(id);
        if (user == null){
            return new CommonResult(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMsg(),null);
        }else {
            return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),user);
        }
    }

    @ApiOperation("查询所有用户")
    @GetMapping(value = "/getAll")
    public CommonResult<User> getAllUser(){
        try{
            List<User> userList = userService.getAllUser();
            return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),userList);
        }catch (Exception e){
            log.error("#############controller异常##################",e);
            return new CommonResult(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMsg(),e.getMessage());
        }
    }

    @ApiOperation("新增用户")
    @PostMapping(value = "/add")
    public CommonResult addUser(@RequestBody User user){
        try{
            log.info("#################controller--add:"+user.toString()+"###############");
            Integer id = userService.addUser(user);
            return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),"主键id:"+id);
        }catch (Exception e){
            log.error("#############controller异常##################",e);
            return new CommonResult(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMsg(),e.getMessage());
        }
    }

}
