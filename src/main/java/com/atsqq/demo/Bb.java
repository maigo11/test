package com.atsqq.demo;

public class Bb {
    private char num3= 97;
    private char num1= 64;
    private int num2 = 0;
    private int flag = 1;
    public synchronized void num1Add() throws InterruptedException {
        while(flag%2==0){
            this.wait();
        }

        System.out.print(++num2);
        System.out.print(++num2);
        flag++;
        this.notifyAll();
    }
    public synchronized void num2Add() throws InterruptedException {
        while(flag%2!=0){
            this.wait();
        }
        System.out.print(++num3);
        flag++;
        this.notifyAll();
    }
}

class Tt{
    public static void main(String[] args) {
        Bb bb = new Bb();
        new Thread(()->{
            try {
                for (int i = 0; i < 26; i++) {
                    bb.num1Add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                for (int i = 0; i < 26; i++) {
                    bb.num2Add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
class Cat{
    private int age;
    private String name;
    private static Cat cat = null;


    private Cat(int age,String name){
        this.age = age;
        this.name =name;
    }
    public static Cat getCat(int age,String name){
        if(cat==null){
           return cat =  new Cat(age,name);
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class tett{
    public static void main(String[] args) {
        Cat cat1 = Cat.getCat(1, "jumao");
        System.out.println(cat1);
        System.out.println(Cat.getCat(1, "xiaohua"));
    }
}