package com.zgs.test.web_demo.test;

import com.zgs.test.web_demo.util.UnsafeInstance;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zgs
 * @date 2021年12月17日 15:52:00
 * volatile 保证有序性代码实例
 */
@Slf4j
public class Jmm05_CodeReorder {
    private volatile static int x = 0, y = 0;
    private volatile static int a = 0, b = 0;

    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    shortWait(10000);
                    a = 1;
                    UnsafeInstance.reflectGetUnsafe().fullFence();
                    x = b;
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    UnsafeInstance.reflectGetUnsafe().fullFence();
                    y = a;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                log.info(result);
            }
        }
    }
}
