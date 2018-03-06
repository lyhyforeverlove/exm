package basic.test.Model;

import java.util.function.IntConsumer;

public class TestRepeat {


    public static void repeat(int n,Runnable action){
        for (int i = 0; i < n; i++) {
            action.run();
        }

    }

    public static void repeat(int n,IntConsumer action){
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }

    }

}
