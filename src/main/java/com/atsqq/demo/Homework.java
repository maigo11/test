package com.atsqq.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

class print{

    private char aChar = 'A';
    private int aNum = 1;
    int ifGo = 0;//判断是否执行的依据
    private Lock lock = new ReentrantLock();//锁
    Condition condition1 = lock.newCondition();//钥匙
    Condition condition2 = lock.newCondition();
    public void printChar(){
        lock.lock();
        try {
            //判断
            while(this.ifGo % 2 != 0){
                condition1.await();
            }
            //执行操作
            System.out.print(this.aChar);
            this.aChar+=1;
            this.ifGo+=1;
            //唤醒其他线程
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printNum(){
        //判断
        lock.lock();
        try {

            while(this.ifGo % 2 == 0){
                condition2.await();
            }
            //干活
            for (int i = 0; i < 2; i++) {
                System.out.print(aNum++);
            }
            //唤醒
            this.ifGo+=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


public class Homework {
    public static void main(String[] args) {
        print print = new print();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                print.printChar();
            }
            },"AAA").start();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                print.printNum();
            }
        },"BBB").start();


    }
}
