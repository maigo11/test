import com.atsqq.demo.Mutex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        demo demo = new demo();
//        CountDownLatch countDownLatch = new CountDownLatch(10000);

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                demo.incr();
//                countDownLatch.countDown();
            }).start();
        }
        Thread.sleep(5000);
//        countDownLatch.await();
        System.out.println(demo.getI());
    }

}
class demo{
    private int i = 0;
//    ReentrantLock reentrantLock = new ReentrantLock();
    Mutex mutex = new Mutex();
    public void incr(){
        mutex.lock();
//        reentrantLock.lock();
        i++;
        mutex.unlock();
//        reentrantLock.unlock();
    }

    public int getI() {
        return i;
    }
}