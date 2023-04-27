package org.example;

import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) throws AWTException {
        System.out.println("开始");
        int a = 0;
        while (true) {
            Robot r = new Robot();
            if (a == 1) {
                r.mouseMove(376, 284);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                a = 0;

            } else {
                r.mouseMove(725, 281);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                a = 1;
            }

            try {
                // 多久一次（1分钟）
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}