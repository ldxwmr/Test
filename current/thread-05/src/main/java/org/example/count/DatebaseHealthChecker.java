package org.example.count;

import java.util.concurrent.CountDownLatch;

/**
 * @author ld
 * @date 2021/9/19 11:19
 */
public class DatebaseHealthChecker extends BaseHealthChecker {

    private CountDownLatch countDownLatch;

    public DatebaseHealthChecker(CountDownLatch countDownLatch) {
        super("DatebaseHealthChecker");
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void verifyService() throws Exception {
        System.out.println("Checking:" + this.getServiceName());
        try {

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        countDownLatch.countDown();
        System.out.println(this.getServiceName() + " 健康状态正常");

    }

}
