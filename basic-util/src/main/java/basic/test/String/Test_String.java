package basic.test.String;

public class Test_String {

    public static void test_1(){
        String a = new String("123");
        String b = a.intern();
        String c = "123";
        System.out.println("a == b ? " + (a == b) );
        System.out.println("b == c ? " + (b == c) );
        System.out.println("a == c ? " + (a == c) );

//        System.out.println("a equals b ? " + (a.equals(b)));
//        System.out.println("c equals b ? " + (c.equals(b)));

    }
    void test_2(){
        String s = new String("123456".getBytes() , 6, 0);
        System.out.println("--->s : " + s);
        String s1 = new String("123456".toCharArray() , 6, 0);
        System.out.println("--->s1 : " + s1);

        int[] ints = new int[]{89,34,56,75,1379};
        String s2 = new String(ints,0,5);
        System.out.println("--->s2 : " + s2);


    }




    public static void main(String[] args) {
        test_1();

        //-21474836482  21474836472
//        Integer a = 128;
//        System.out.println("--->:" + a + "--2进制：" + Integer.toBinaryString(a) + " 负数 " + Integer.toBinaryString(-a));
//        System.out.println("--->:" + Integer.toBinaryString(a >>> 3) + "!");

        String a = "当,我们,查看,JDK,API,的时候，总会,发,现一些,类说,明,写着，线程,安全,或者,线程,不安,全，比如,说到,StringBuilder,中，有这么,一句";
        String[] split = a.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        String b = new String(sb.toString());
        String c = new String("123");
        System.out.println("sb ---> :" + b + " hashcode:" + b.hashCode());

//        Test_1 $1 = new Test_1();
//        $1.test_1();
//        $1.test_2();


    }


}
