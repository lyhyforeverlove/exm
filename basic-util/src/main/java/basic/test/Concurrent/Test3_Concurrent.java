package basic.test.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Test3_Concurrent{

    int count = 0;
    void increment(){
        count = count + 1;
    }

    void incrementS(){
        synchronized (this){
            count = count + 1;
        }
    }
    synchronized void incrementSync(){
        count = count + 1;
    }

    void executor(){

        ExecutorService executor = Executors.newFixedThreadPool(1);
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::incrementS));
        executor.shutdownNow();
        System.out.println(count + " <--- " + Thread.currentThread().getName());
    }



    public static void main(String[] args) {
        Test3_Concurrent t3c = new Test3_Concurrent();
        t3c.executor();
//        System.out.println("循环后的结果：" + t3c.getCount() + " <--- " + Thread.currentThread().getName());



    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
