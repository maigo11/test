package com.atsqq.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //设置能够执行的线程数量
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    //抢占一个执行权限
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢占了一个执行权限");
                    Thread.sleep(500);
//                TimeUnit.SECONDS.sleep(0.5);
                    System.out.println(Thread.currentThread().getName()+"执行完成重新恢复执行权限名额");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"aaa"+i).start();
        }
    }
}
