package com.atsqq.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.applet.Main;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("11");
        });
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("33");
        });
        thread1.start();
        thread.start();
        thread1.join();
        thread.join();
        System.out.println("main");

//        Thread.sleep(2000);
//        System.out.println("22");
    }

}
