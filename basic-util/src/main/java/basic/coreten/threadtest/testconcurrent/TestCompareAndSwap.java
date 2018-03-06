package basic.coreten.threadtest.testconcurrent;

import java.util.stream.IntStream;

public class TestCompareAndSwap {

    public static void main(String[] args) {
        CompareAndSwap cas = new CompareAndSwap();
        IntStream.rangeClosed(1,10)
                .forEach(i -> {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int oldValue = cas.get();
                            System.out.println(cas.compareAndSet(oldValue,(int) (Math.random() * 100)));
                        }
                    }).start();
                });
    }


}

class CompareAndSwap{
    private int value;

    //获取内存的值
    public synchronized int get(){
        return value;
    }
    //比较和替换
    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = value;
        System.out.println("expectedValue: " + expectedValue + "---" + "oldValue: " + value + "---" + "nowValue: " + newValue);
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;

    }
    public synchronized boolean compareAndSet(int expectedValue,int newValue){
        return expectedValue == compareAndSwap(expectedValue,newValue);
    }



}
