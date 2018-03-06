package basic.test.Concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Test2 {

    static int testCallable() throws Exception{
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep((long) 1);
                return 123;
            } catch (Exception e) {
                throw new RuntimeException("task interrupted",e);
            }
        };
        Integer call = task.call();
        return call;
    }

    public static void main(String[] args) throws Exception{
//        System.out.println(testCallable());
//        String a = Integer.toBinaryString(11);
//        System.out.println(a);
//        String b = Integer.toBinaryString(12);
//        System.out.println(b);
//        //异或运算  二进制中只要是两者的值不一样那么就是1
//        int i = Integer.parseInt(a) ^ Integer.parseInt(b);
//        System.out.println("异或取值：" + i + "--->二进制：" + Integer.toBinaryString(i));

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep((long) 2);
                return 123;
            } catch (Exception e) {
                throw new RuntimeException("task interrupted",e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        try {
            Future<Integer> future = executor.submit(task);

            System.out.println("future done ? " + future.isDone());
            //超时设   置
            Integer result = future.get((long) 1,TimeUnit.SECONDS);

            System.out.println("future done ? " + future.isDone());
            System.out.println("result: " + result);
            executor.shutdown();
        } catch (Exception  e) {
            e.printStackTrace();
            executor.shutdown();
        } finally {
            if (executor.isTerminated()) {
                executor.shutdownNow();
            }
        }

    }


}
