package com.atsqq.demo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {
    public static void main(String[] args) {
//        test();
        ArrayList<Object> list = new ArrayList<>();
        List<Object> synLIst = Collections.synchronizedList(list);
        List<Object> list1 = new CopyOnWriteArrayList<>();

    }

    public static void test() {
        //        ArrayList<Object> list = new ArrayList<>();//1.5倍扩容相对来说不那么占内存
        List<Object> list = new Vector<>();//两倍扩容，占内存
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },"AA"+i).start();

        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
