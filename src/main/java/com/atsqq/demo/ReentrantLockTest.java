package com.atsqq.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源对象
class book{
    //库存数
    private Integer num = 20;
    //锁
    Lock lock = new ReentrantLock(true);


    //卖书方法
    public void sellBook(){
//        lock.tryLock(10, TimeUnit.SECONDS);
        lock.lock();
        //判断
        if(this.num<=0) {
            System.out.println("商品售罄");
            lock.unlock();
            return;
        }
        this.num-=1;
        System.out.println("恭喜"+Thread.currentThread().getName()+"抢到商品剩余"+this.num+"件");
        lock.unlock();
    }
}


public class ReentrantLockTest {
    public static void main(String[] args) {
        book book = new book();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 5; i1++) {
                    book.sellBook();
                }
            },"aa"+i).start();
        }
    }
}
