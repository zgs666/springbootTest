package com.zgs.test.maindemo.service.test;

import java.util.concurrent.*;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author 张贵松
 * @version 1.0.0
 * @ClassName ThreadPool.java
 * @Description
 * @createTime 2021年09月16日 17:53:00
 */
public class ThreadPool {
    /**
     * 1: Executors
     * 不支持自定义拒绝策略。
     * newFixedThreadPool 和 newSingleThreadExecutor：主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至 OOM。
     * newCachedThreadPool 和 newScheduledThreadPool：主要问题是线程数最大数是 Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至 OOM。
     */
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    /**
     * 2: ThreadPoolExecutor--阿里巴巴的JAVA开发手册推荐用ThreadPoolExecutor创建线程池
     * corePoolSize    线程池核心池的大小
     * maximumPoolSize 线程池中允许的最大线程数量
     * keepAliveTime   当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间
     * unit            keepAliveTime 的时间单位
     * workQueue       用来储存等待执行任务的队列
     * threadFactory   创建线程的工厂类
     * handler         拒绝策略类,当线程池数量达到上线并且workQueue队列长度达到上限时就需要对到来的任务做拒绝处理
     */
    /**
     *  自定义线程名称,方便的出错的时候溯源
     */
    /**
     * 有请求时，创建线程执行任务，当线程数量等于corePoolSize时，请求加入阻塞队列里，当队列满了时，接着创建线程，线程数等于maximumPoolSize。 当任务处理不过来的时候，线程池开始执行拒绝策略。
     *
     * 　　阻塞队列：
     *
     * 　　ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
     *
     * 　　LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
     *
     * 　　PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
     *
     * 　　DelayQueue： 一个使用优先级队列实现的无界阻塞队列。
     *
     * 　　SynchronousQueue： 一个不存储元素的阻塞队列。
     *
     * 　　LinkedTransferQueue： 一个由链表结构组成的无界阻塞队列。
     *
     * 　　LinkedBlockingDeque： 一个由链表结构组成的双向阻塞队列。
     *
     * 　　拒绝策略：
     *
     * 　　ThreadPoolExecutor.AbortPolicy: 丢弃任务并抛出RejectedExecutionException异常。 (默认)
     *
     * 　　ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     *
     * 　　ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务。（重复此过程）
     *
     * 　　ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务。
     */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();
    private static ExecutorService service = new ThreadPoolExecutor(
            4,
            40,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy()
    );
    /**
     * 获取线程池
     */
    public static ExecutorService getEs() {
        return service;
    }

    /**
     * 使用线程池创建线程并异步执行任务
     * @param r 任务
     */
    public static void newTask(Runnable r) {
        service.execute(r);
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("#####threadPool:["+Thread.currentThread().getName()+"]#######");
                }
            });
            
            threadPool.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return null;
                }
            });

            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("#####service:["+Thread.currentThread().getName()+"]#######");
                }
            });

            service.submit(new Callable<Object>(){
                @Override
                public Object call() throws Exception {
                    return null;
                }
            });
        }
        newTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111111111111111");
            }
        });
        threadPool.shutdown();
        service.shutdown();
    }
}
