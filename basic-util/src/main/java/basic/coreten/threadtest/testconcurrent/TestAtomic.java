package basic.coreten.threadtest.testconcurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TestAtomic {

    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        IntStream.rangeClosed(1,10)
                .forEach(i -> {
                    new Thread(ad).start();
                });


    }
}

class AtomicDemo implements Runnable{

    private volatile int a = 0;
    //原子性变量 java.util.concurrent.atomic 包下提供了大量常用的原子变量
    private AtomicInteger ag = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        System.out.println(getA());
        System.out.println("-" + getAg());
    }

    public int getAg() {
        return ag.getAndIncrement();
    }

    public int getA(){
        return a++;
    }
}
