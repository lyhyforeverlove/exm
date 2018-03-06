package basic.test.Concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test1 {

    static void Runnable1(){
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Hello:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
    }
    static void Runnable2(){
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable: " + Thread.currentThread().getName());
            }
        };
        new Thread(task1).start();
    }
    static void ExecutorService(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(()-> {
                System.out.println("Hello " + Thread.currentThread().getName());
            });
            executorService.shutdown();
            executorService.awaitTermination(5,TimeUnit.SECONDS);
//            throw new RuntimeException("测试");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (executorService.isTerminated()) {
                System.err.println("executorService is not shutdown");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }


    public static void main(String[] args) {
//        Test1.Runnable1();
////        Test1.Runnable2();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Done!");

//        ExecutorService();


    }


}
