package com.atsqq.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Data{
    private Integer num = 0;
    public synchronized void sum(){
        num++;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

public class DataOne {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
        //手动创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(500, 1000, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(30));
        for (int i = 0; i < 999; i++) {
            threadPoolExecutor.execute(()->{
                data.sum();
//                System.out.println(data.getNum());
            });
        }

        Thread.sleep(3000);
        System.out.println(data.getNum());
        threadPoolExecutor.shutdown();
    }

    public static void test() throws InterruptedException {
        Data data = new Data();

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
               data.sum();
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(data.getNum());
    }
}
