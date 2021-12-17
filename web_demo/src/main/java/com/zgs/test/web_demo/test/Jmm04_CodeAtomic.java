package com.zgs.test.web_demo.test;

/**
 * @author zgs
 * @date 2021年12月17日 15:43:00
 * volatile 不保证原子性代码实例
 */
public class Jmm04_CodeAtomic {
    private volatile static int counter = 0;
    static Object object = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (object) {
                        counter++;//分三步- 读，自加，写回
                    }
                }
            });
            t.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }
}
