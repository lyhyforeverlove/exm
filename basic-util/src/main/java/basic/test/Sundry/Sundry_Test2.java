package basic.test.Sundry;

import basic.test.Model.TestRepeat;

public class Sundry_Test2 {

    public static void main(String[] args) {

        TestRepeat.repeat((int) 10,() -> System.out.println("Hello Word"));

        TestRepeat.repeat((int) 10,k -> System.out.println("Countdown: " + (9 - k)));




    }

}
