package com.atsqq.demo;

public class VolatileOrderDemo {
    private static int a,b;
    private  static int x,y;

    public static void main(String[] args) throws InterruptedException {
        while(true){
            a = b = x = y = 0;
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println("x=:"+x+" y=:"+y);
            if (x == 0 && y == 0){
                break;
            }
        }

    }
}
