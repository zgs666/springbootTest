package com.zgs.test.web_demo.util;

import org.springframework.stereotype.Component;

/**
* @author zgs
* @date 2021/11/11 16:51
*/
@Component
public class RedisUtil {
    /**
    * @author zgs
    * @date 2021/11/11 16:51
    * @return  String
     * @param redisOpsForListStr redis字符
    */
    // redisOpsForList会带有[];手动去除，否则会解析出错
    public String redisOpsForListSubStr(String redisOpsForListStr){
        String redisOpsForListSubStr = redisOpsForListStr.substring(1,redisOpsForListStr.length()-1);
        return redisOpsForListSubStr;
    }

}
