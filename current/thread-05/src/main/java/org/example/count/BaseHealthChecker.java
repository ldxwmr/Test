package org.example.count;

/**
 * @author ld
 * @date 2021/9/19 11:04
 */
public abstract class BaseHealthChecker implements Runnable {

    private String serviceName;// 服务名称
    private boolean serviceUp;

    public BaseHealthChecker(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Exception e) {
            e.printStackTrace();
            serviceUp = false;
        }finally {

        }

    }

    /**
     * 检查服务的健康情况
     */
    public abstract void verifyService() throws Exception;

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }
}
