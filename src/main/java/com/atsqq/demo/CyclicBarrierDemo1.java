package com.atsqq.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo1 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("人员已经到齐任务开始");//CyclicBarrier后面的方法都是最后一个到达3的那个线程执行的
            System.out.println("过关了");//当线程的等待数量已经到达指定数量时，自动执行CyclicBarrier后的方法,可以多次执行
        });
        for (int i = 0; i < 3; i++) {
            String s = String.valueOf(i);
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号选手已经到位");
                try {
                    cyclicBarrier.await();


                    System.out.println(Thread.currentThread().getName()+"号选手已经到位");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"选手"+i).start();
        }
    }
}
