package basic.coreten.threadtest.testconcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**解决多线程安全问题的方式：三种
 * Synchronized
 * 一：同步方法
 * 二：同步代码块
 *
 * JDK1.5后：Lock
 * 三：同步锁：显示锁，通过lock.lock上锁，通过lock.unLock解锁
 *
 * @author ying
 */
public class TestLock {

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        new Thread(lockDemo,"1号窗口").start();
//        new Thread(lockDemo,"2号窗口").start();
//        new Thread(lockDemo,"3号窗口").start();

    }

}

class LockDemo implements Runnable{
    private int tikect = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tikect > 0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName() + "余票为：" + --tikect);
                }

            } finally {
                lock.unlock();
            }


        }


    }
}
