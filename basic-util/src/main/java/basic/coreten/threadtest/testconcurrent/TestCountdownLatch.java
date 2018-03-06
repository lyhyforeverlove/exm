package basic.coreten.threadtest.testconcurrent;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**闭锁：等待所有线程完成
 * @author ying
 */
public class TestCountdownLatch {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final CountDownLatch downLatch = new CountDownLatch(5);
        Latch latch = new Latch(downLatch);

        IntStream.rangeClosed(1,5)
                .forEach(i -> {
                    new Thread(latch).start();
                });
        try {
            downLatch.await();
        } catch (InterruptedException e) {
        }
        System.out.println("总时间：" + (System.currentTimeMillis() - start));

    }

}
class Latch implements Runnable{
    private CountDownLatch cdl;

    public Latch(CountDownLatch cdl){
        this.cdl = cdl;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                IntStream.rangeClosed(1,100)
                        .forEach(i -> {
                            if (i % 2 == 0) {
                                System.out.println(Thread.currentThread().getId() + ": " + i);
                            }
                        });
            } finally {
                cdl.countDown();
            }
        }
    }
}
