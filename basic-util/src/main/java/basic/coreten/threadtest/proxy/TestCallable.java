package basic.coreten.threadtest.proxy;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author ying
 */
public class TestCallable {

    public static void main(String[] args) throws Exception{
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask).start();
        Integer integer = futureTask.get((int)2, TimeUnit.SECONDS);
        //FutureTask 可以用于闭锁操所：即等待线程执行完毕后才执行主线程
        System.out.println(integer);
        System.out.println("=====");


    }

}
//创建执行线程方式第一种：继承Thread类
//创建执行线程方式第二种：实现Runnable接口
//class CallableRunnable implements Runnable{
//
//    @Override
//    public void run() {
//
//    }
//}

//创建执行线程方式第三种：实现Callable接口
class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
//        Thread.sleep(1000);
        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            sum = sum + i;
        }
        return sum;
    }

}
