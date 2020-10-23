package com.atsqq.demo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        //线程计数器 当new方法时
        try {
            CountDownLatch countDownLatch = new CountDownLatch(5);
            for (int i = 0; i < 5; i++) {
                String s = String.valueOf(i);
                new Thread(()->{
                    System.out.println(s+"号同学出门了");
                    countDownLatch.countDown();//每次执行难该方法的时候计数器减一
                },"AAA"+i).start();
            }
            countDownLatch.await();//当计数器归零的时候就执行下面的代码
            System.out.println("值班的同学锁门了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
