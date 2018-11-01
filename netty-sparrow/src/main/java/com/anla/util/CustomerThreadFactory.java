package com.anla.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @user anLA7856
 * @time 18-11-1 下午10:57
 * @description 自定义线程构造工厂
 */
public class CustomerThreadFactory implements ThreadFactory {
    private final AtomicInteger threadCount = new AtomicInteger(0);
    private final String prefix;
    private final boolean daemon;
    private final ThreadGroup group;

    public CustomerThreadFactory(String prefix, boolean daemon){
        this.prefix = prefix;
        this.daemon = daemon;
        SecurityManager manager = System.getSecurityManager();
        group = manager != null? manager.getThreadGroup():Thread.currentThread().getThreadGroup();
    }

    public Thread newThread(Runnable r) {
        String threadName = prefix + '_' + threadCount.getAndIncrement();
        Thread thread = new Thread(group, r, threadName);
        thread.setDaemon(daemon);
        return thread;
    }
}
