package com.zolarrobot.baselib.utils;

/**
 * Created by Go on 2018/8/14.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static ThreadPool threadPool;
    private ExecutorService executorService;

    private ThreadPool() {
        executorService = Executors.newFixedThreadPool(10);
    }

    public static ThreadPool getInstace() {
        if (threadPool == null) {
            threadPool = new ThreadPool();
        }
        return threadPool;
    }

    public void exeRun(Thread thread) {
        if (executorService.isShutdown()) {
            executorService = Executors.newFixedThreadPool(10);
        }
        executorService.execute(thread);
    }

    public void shutdownNow() {
        executorService.shutdownNow();

    }
}
