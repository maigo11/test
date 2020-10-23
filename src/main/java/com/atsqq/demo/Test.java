package com.atsqq.demo;

class SellBook{
    private Integer num = 10;//库存
    //买书
    public synchronized void sellBook(){
        //判断
        if(this.num <= 0){
            System.out.println("商品已售罄。。。");
            return;
        }
        this.num -= 1;
        System.out.println("恭喜"+Thread.currentThread().getName()+"抢购成功"+"当前还剩"+this.num+"本库存");
    }
}

public class Test {
    public static void main(String[] args) {
        SellBook sellBook = new SellBook();

        synchronizedSellBook(sellBook);
    }

    public static void synchronizedSellBook(SellBook sellBook) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 5; i1++) {
                    sellBook.sellBook();
                }
            },"AA"+i).start();
        }
    }

}
