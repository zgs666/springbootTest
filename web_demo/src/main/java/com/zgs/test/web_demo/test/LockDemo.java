package com.zgs.test.web_demo.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zgs
 * @date 2021年10月27日 17:19:00
 */
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            
        }catch (Exception e ){

        }finally {
           lock.unlock();
        }
    }
}
