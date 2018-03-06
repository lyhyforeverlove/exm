package basic.test.Sundry;

import basic.test.Model.Person;

import java.util.*;

public class Objects_Main {

    public static void main(String[] args) throws Exception{
//        Integer a = 10;
//        Integer b = null;
//        System.out.println(Objects.nonNull(a));
//        System.out.println(Objects.isNull(b));
//        System.out.println(Objects.equals(a,b));

//        List<Integer> aList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            aList.add(i + 1);
//        }
//        List<Integer> bList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            bList.add(i + 1);
//        }
//        System.out.println(aList.equals(bList));
//        System.out.println(Objects.deepEquals(aList,bList));

        Random random = new Random();
        List<Person> p1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setId(i /*+ random.nextInt(10)*/);
            person.setAge(i + 10);
            person.setFirstName("test" + i);
            p1.add(person);
        }
        List<Person> p2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setId(i /*+ random.nextInt(10)*/);
            person.setAge(i + 10);
            person.setFirstName("test" + i);
            p2.add(person);
        }
//        p1.forEach(p -> {
//            System.out.println("p1 ---> : " + p);
//        });
//        p2.forEach(p -> {
//            System.out.println("p2 ---> : " + p);
//        });
//        System.out.println(Objects.equals(p1,p2));
//        System.out.println(Objects.deepEquals(p1,p2));
//        System.out.println(p1.equals(p2));

        String ab1 = null;
        String ab2 = new String("abc");
        String ab3 = "abc";
//        System.out.println(Objects.equals(ab1,ab2));
//        System.out.println(ab2.equals(ab1));
//        System.out.println(ab1 == ab2);

        String ab1IsNull = Objects.requireNonNull(ab1, "ab1 must not be null");
        System.out.println(ab1IsNull);


    }
}
