package com.atsqq.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Callable<>()
        FutureTask futureTask = new FutureTask<>(new test01());//FutureTask继承了runnable接口
        FutureTask futureTask1 = new FutureTask<>(new test01());//FutureTask继承了runnable接口
//        Thread.sleep(3000);
        new Thread(futureTask).start();
        new Thread(futureTask1).start();
        Object o = futureTask.get();
        System.out.println(o);

    }
}
class test implements Runnable {

    @Override
    public void run() {

    }
}
class test01 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"这是callable方法的输出");
            return "11";
    }
}
