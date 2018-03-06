package basic.util;

import java.util.concurrent.*;

public class TestFuture {

    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newCachedThreadPool();

            Runnable task1 = new Runnable() {
                @Override
                public void run() {
                    System.out.println("--->: task1执行。。。。。。" );
                }
            };
            Callable<Integer> task2 = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return new Integer(100);
                }
            };
            Future<?> future1 = executor.submit(task1);
            Future<Integer> future2 = executor.submit(task2);
            System.out.println("future1 --->: " + future1.isDone());
            System.out.println("future2 --->: " + future2.isDone());
            while (future1.isDone()) {
                System.out.println("task1 is completed.");
                break;
            }
            while (future2.isDone()) {
                System.out.println("task2 is completed." + future2.get());
                break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
