package com.zgs.test.web_demo.util;

import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    // redisOpsForList会带有[];手动去除，否则会解析出错
    public String RedisOpsForListSubStr(String redisOpsForListStr){
        String redisOpsForListSubStr = redisOpsForListStr.substring(1,redisOpsForListStr.length()-1);
        return redisOpsForListSubStr;

    }
}
