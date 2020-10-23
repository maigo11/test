package com.atsqq.demo;

public class VolatileDemo {
    private volatile static Integer num = 0;

    public static void main(String[] args) {

           new Thread(()->{
               while(num == 0){
                   System.out.println(1);
               }


           }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 2;
        System.out.println(num);
    }

}
