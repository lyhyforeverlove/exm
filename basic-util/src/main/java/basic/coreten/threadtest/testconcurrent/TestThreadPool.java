package basic.coreten.threadtest.testconcurrent;

import java.util.Objects;
import java.util.concurrent.*;

/**一、线程池：提供一个线程的队列，队列中保存着所有等待状态的线程。避免了创建和销毁的额外开销，
 *                  提升响应的速度。
 *
 * 二、线程池的体系结构：
 *          |--java.util.concurrent.Executor : 负责线程的使用和调度
 *              |--ExecutorService 子接口：线程池的主要接口（核心）
 *                  |--ThreadPoolExecutor 线程接口的实现类
 *                  |--ScheduledExecutorService 子接口：负责线程调度
 *                      |--ScheduledThreadPoolExecutor  实现类：继承ThreadPoolExecutor，
 *                                                          实现ScheduledExecutorService
 * 三、Executors工具类生成线程池方式：
 *          ExecutorService newCacheThreadPool():缓存线程池，线程池的数量不固定，可以根据需求自动更改数量
 *          ExecutorService newFixedThreadPool():创建固定的线程池
 *          ExecutorService newSingleThreadExecutor():创建单个的线程池，线程池中只有一个线程
 *
 *          ScheduledExecutorService newScheduledThreadPool();创建固定大小的线程池，可以延时或定时的执行任务
 * @author ying
 */
public class TestThreadPool {

    public static ExecutorService getExecutorService(String name){
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat(name).build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 200
                , 0L, TimeUnit.MILLISECONDS
                , new LinkedBlockingDeque<>(1024)
                , nameThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        return executorService;
    }

    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        IntStream.rangeClosed(1,10)
//                .forEach(i -> executorService.submit(new ThreadPoolDemo()));
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        IntStream.rangeClosed(1,100)
//                .forEach(i -> executorService.submit(new ThreadPoolDemo()));
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        IntStream.rangeClosed(1,10)
//                .forEach(i -> executorService.submit(new ThreadPoolDemo()));
//        executorService.shutdown();

        //实战应用中需要手动建立连接池来建立线程
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5
                , 5, 0L
                , TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024)
                ,new ThreadFactoryBuilder().setNameFormat("hello-").build()
                ,new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 100; i++) {
                executor.execute(new ThreadPoolDemo());
            }
        }catch(Exception e){
            throw e;
        }finally {
            executor.shutdown();
        }



    }


}
class ThreadFactoryBuilder{
    private String nameFormat;

    public ThreadFactoryBuilder setNameFormat(String name) {
        if (!Objects.isNull(name)) {
            this.nameFormat = name;
        }
        return this;
    }
    public ThreadFactory build(){
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                if (!Objects.isNull(nameFormat)) {
                    thread.setName(nameFormat + ":" +  thread.getName());
                }
                return thread;
            }
        };
    }

}

class ThreadPoolDemo implements Runnable{

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " : " + sum);

    }
}
