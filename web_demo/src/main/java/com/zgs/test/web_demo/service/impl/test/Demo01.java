package com.zgs.test.web_demo.service.impl.test;

import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.text.BasicTextEncryptor;

/**
* @author 张贵松
* @since 1.0
* @date 2021/9/23 16:37
*/
public class Demo01 {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //放置密钥
        textEncryptor.setPassword("zgs");
        //具体密码
        String password = textEncryptor.encrypt("qwer");
        System.out.println(password);
        String x = "ENC("+password+")";
        System.out.println(x);
        if (PropertyValueEncryptionUtils.isEncryptedValue(x)){
            System.out.println(PropertyValueEncryptionUtils.decrypt(x,textEncryptor));
        }
    }

}
