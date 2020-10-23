package com.atsqq.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Cache{
   private Map map = new HashMap<String,Object>();
   Lock lock = new ReentrantLock();
    ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
   //写方法
    public void write(String key,Object value){
//        lock.lock();
        rwlock.writeLock().lock();//写锁
        try {
            System.out.println(Thread.currentThread().getName()+"开始写入数据");
//            Thread.sleep(500);
            map.put(key,value);
            System.out.println("写入数据完成");
            rwlock.writeLock().unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }

//            lock.unlock();


    }
    //读方法
    public void read(String key){
        rwlock.readLock().lock();
//        lock.lock();
        try {
            Object o = map.get(key);
//        Thread.sleep(3000);
//            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+"读取到了数据"+o);
            //            lock.unlock();
            rwlock.readLock().unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class CacheDemo {
    public static void main(String[] args) {
        Cache cache = new Cache();//资源对象
//        cache.read("1");
        for (int i = 0; i < 10; i++) {
            String i1 = String.valueOf(i);
            new Thread(()->{
               cache.write(i1,i1+"value");
           },"AA"+i).start();
        }
        for (int i = 0; i < 10; i++) {
            String i1 = String.valueOf(i);
            new Thread(()->{
                cache.read(i1);
            },"BB"+i).start();
        }
    }

}
