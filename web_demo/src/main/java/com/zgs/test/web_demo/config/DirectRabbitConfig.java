package com.zgs.test.web_demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * zgs
 * version:1
 */
@Configuration
public class DirectRabbitConfig {
    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirectQueue(){

        return new Queue("TestDirectQueue",true);
    }
}
