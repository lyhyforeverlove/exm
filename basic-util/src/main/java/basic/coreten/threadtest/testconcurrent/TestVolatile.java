package basic.coreten.threadtest.testconcurrent;


/**
 * volatile关键字：当多个线程操作共享数据时，可以保证内存中的数据是可见的。
 *      相较于 synchronized 是一种轻量级的 同步策略。
 * 不同处为：
 * 1：volatile 关键字 不具备“互斥性”（synchronized为互斥锁，
 *      只有一个锁能进入被synchronized修饰的字段或语句块）。
 * 2：volatile 关键字不能保证变量的“原子性”。
 */
public class TestVolatile {

    public static void main(String[] args) throws Exception{
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();

        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("读取flag值成功！");
                break;

            }
        }


    }

}




class ThreadDemo implements Runnable{
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        flag = true;
        System.out.println("flag = " + isFlag());


    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

