import java.util.concurrent.*;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5,
                2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3)
                , Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                //自定义拒绝策略
                System.out.println("自定义处理了多余请求");
            }
        });
        for (int i = 0; i <10; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPoolExecutor.shutdown();

    }
}
