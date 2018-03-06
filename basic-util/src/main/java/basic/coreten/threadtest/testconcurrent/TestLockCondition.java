package basic.coreten.threadtest.testconcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**使用Lock  Condition 测试生产者和消费者案例
 * @author ying
 */
public class TestLockCondition {

    public static void main(String[] args) {
        ClerkLock clerkLock = new ClerkLock();

        ProducerLock pLock = new ProducerLock(clerkLock);
        ConsumerLock cLock = new ConsumerLock(clerkLock);

        ExecutorService executorService = TestThreadPool.getExecutorService("LockCondition");

        executorService.execute(pLock);
        executorService.execute(cLock);
        executorService.execute(pLock);
        executorService.execute(cLock);

        executorService.shutdown();

    }

}

//店员
class ClerkLock{
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //进货
    public void get(){
        lock.lock();
        try {
            while (product >= 1) {
                System.out.println("货物已满！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + ++product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }


    }

    //出货
    public void sale(){
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("没货了");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }


}

//生产者
class ProducerLock implements Runnable{

    private ClerkLock clerk;

    public ProducerLock(ClerkLock clerk) {
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
class ConsumerLock implements Runnable{

    private ClerkLock clerk;

    public ConsumerLock(ClerkLock clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//            }
            clerk.sale();
        }
    }
}