package org.example.count;

/**
 * @author ld
 * @date 2021/9/19 11:42
 */
public class StartupMain {
    public static void main(String[] args) {
        try {
            ApplicationStartup.checkExternalServices();

        } catch (InterruptedException e) {
            e.printStackTrace();
            // 有问题了
        }
        System.out.println("服务启动成功");
    }
}
