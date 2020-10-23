package com.atsqq.demo;

public class Aa {
    private char num1 = 64;
    private Integer num2 = 0;
    private Integer flag = 0;
    public synchronized void  addNum() throws InterruptedException {
        while(flag % 2 == 0){
            this.wait();
        }
        System.out.print(++num2);
        System.out.print(++num2);
        flag++;
        this.notifyAll();
    }
    public synchronized void addChar() throws InterruptedException {
        while(flag % 2 != 0){
            this.wait();
        }
        System.out.print(++num1);
        flag++;
        this.notifyAll();
    }


}
class test111{
    public static void main(String[] args) {
        Aa aa = new Aa();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                try {
                    aa.addChar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                try {
                    aa.addNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

