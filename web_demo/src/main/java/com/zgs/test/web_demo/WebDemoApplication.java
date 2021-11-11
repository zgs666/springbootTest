package com.zgs.test.web_demo;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableEncryptableProperties
public class WebDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
    }

}
