package basic.coreten.threadtest.testconcurrent;

import java.util.concurrent.*;

/**线程等待唤醒机制：
 *      多个线程操作同时竞争一个锁，等待和唤醒机制容易造成  虚假唤醒：所以object.wait()应该使用在循环中如：
 *              synchronized(this){
 *                  while(..){
 *                      this.wait();
 *                  }
 *              }
 * 生产者消费者案例：
 *      生产者生产东西，交给店员卖出
 *      消费者购买冻死，从店员处购买
 *
 * 添加和创建线程为 生产者线程
 * 删除和销毁线程为 消费者线程
 * @author ying
 */
public class TestProductorAndConsumer {



    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

//        new Thread(producer,"生产者A").start();
//        new Thread(consumer,"消费者B").start();
//        new Thread(producer,"生产者C").start();
//        new Thread(consumer,"消费者D").start();

//        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("name-1").build();
//        ExecutorService executorService = new ThreadPoolExecutor(5, 200
//                , 0L, TimeUnit.MILLISECONDS
//                , new LinkedBlockingDeque<>(1024)
//                , nameThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        ExecutorService executorService = TestThreadPool.getExecutorService("ProducerAndConsumer");
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(producer);
        executorService.execute(consumer);

        executorService.shutdown();

    }

}

//店员
class Clerk{
    private int product = 0;

    //进货
    public synchronized void get(){
        while (product >= 1) {//为了虚假唤醒问题，Object.wait()方法应该总是使用在循环中
            System.out.println("货物已满！");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + ++product);
        this.notifyAll();



    }

    //出货
    public synchronized void sale(){
        while (product <= 0) {
            System.out.println("没货了");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + --product);
        this.notifyAll();

    }


}

//生产者
class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            clerk.sale();
        }
    }
}

