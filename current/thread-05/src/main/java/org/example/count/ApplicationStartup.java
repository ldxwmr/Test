package org.example.count;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author ld
 * @date 2021/9/19 11:37
 */
public class ApplicationStartup {
    private static List<BaseHealthChecker> services;
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    static {
        services = new ArrayList<>();
        services.add(new CacheHealthChecker(countDownLatch));
        services.add(new DatebaseHealthChecker(countDownLatch));
    }

    private final static ApplicationStartup INSTANCE = new ApplicationStartup();

    private ApplicationStartup() {
    }

    public static ApplicationStartup getInstance() {
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws InterruptedException {
        for (BaseHealthChecker service : services) {
            new Thread(service).start();
        }
        countDownLatch.await();
        return true;
    }
}
