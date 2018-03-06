package basic.coreten.threadtest.testconcurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**线程例子：
 *      开启三个线程A,B,C，每个线程打印按照名称10遍，按照顺序交替打印ABCABCABC......如此递归
 * @author ying
 */
public class TestAlternate {

    public static void main(String[] args) {

        Alternate alternate = new Alternate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternate.loopA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternate.loopB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternate.loopC(i);
                }
            }
        },"C").start();

    }

}
//按序交替打印类
class Alternate{
    //标记
    private int no = 1;

    private Lock lock = new ReentrantLock();
    private Condition cd1 = lock.newCondition();
    private Condition cd2 = lock.newCondition();
    private Condition cd3 = lock.newCondition();

    public void loopA(int count){
        lock.lock();

        try {
            //判断标记
            if (no != 1) {
                try {
                    cd1.await();
                } catch (InterruptedException e) {
                }
            }

            //循环打印
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i + " : " + count);

            }

            //单独唤醒，更新标记
            no = 2;
            cd2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int count){
        lock.lock();

        try {
            //判断标记
            if (no != 2) {
                try {
                    cd2.await();
                } catch (InterruptedException e) {
                }
            }

            //循环打印
            for (int i = 0; i < 11; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i + " : " + count);

            }

            //单独唤醒，更新标记
            no = 3;
            cd3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int count){
        lock.lock();

        try {
            //判断标记
            if (no != 3) {
                try {
                    cd3.await();
                } catch (InterruptedException e) {
                }
            }

            //循环打印
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i + " : " + count);
            }
            System.out.println("------------------------------");
            //单独唤醒，更新标记
            no = 1;
            cd1.signal();
        } finally {
            lock.unlock();
        }
    }


}
