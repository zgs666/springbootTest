package com.zgs.test.web_demo.service.impl.test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zgs
 * @date 2021年10月26日 10:54:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JasyptTest {
    @Autowired
    private StringEncryptor stringEncryptor;
    @Test
    public void encryptPwd(){
        //加密123456
        String result = stringEncryptor.encrypt("123456");
        System.out.println("加密后密码为-----------------:"+result);
    }
}
