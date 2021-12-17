package com.zgs.test.web_demo.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zgs
 * @date 2021年12月17日 15:26:00
 * volatile 保证可见性代码示例
 */
@Slf4j
public class Jmm03_CodeVisibility {
    private volatile static boolean initFlag = false;
    private static int counter = 0;

    public static void refresh() {
        log.info("refresh data.......");
        initFlag = true;
        log.info("refresh data success.......");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!initFlag) {
                counter++;
            }
            log.info("线程:" + Thread.currentThread().getName() + "当前线程嗅探到initFlag的状态的改变");

        }, "threadA");
        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            refresh();
        }, "threadB");
        t2.start();
    }
}
