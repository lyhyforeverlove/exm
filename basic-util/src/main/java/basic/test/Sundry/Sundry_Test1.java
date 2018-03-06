package basic.test.Sundry;

import basic.test.Model.TestAbstractCla;
import basic.test.Model.TestImpl;
import basic.test.Model.TestService;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sundry_Test1 {

    public static void main(String[] args) {
//        自动装箱规范要求 boolean、byte、char 127， 介于 -128 ~ 127 之间的 short 和
//        int 被包装到固定的对象中。例如，如果在前面的例子中将 a 和 b 初始化为 100，对它们
//                进行比较的结果一定成立
        Integer a = 1000;
//        Integer b = 1000;
//        System.out.println( a == b.intValue());
//
//        Boolean b1 = Boolean.TRUE;
//        System.out.println(Boolean.parseBoolean("true") + b1.toString());
//
//        Integer n = 1;
//        Double x = 2.0;
//        //Integer自动装箱为Double
//        System.out.println(true ? n : x);

//        System.out.println(TestAbstractCla.getName("Hello P"));
//        System.out.println(TestService.getName("Hello J"));
//        TestAbstractCla test = new TestImpl();
//        System.out.println(test.getAge());
//        TestService testService = new TestImpl();
//        System.out.println(testService.getAge("Hello K"));

//        Comparator<String> comparator =
//                (String x, String y) -> {
//                    int i = x.length() - y.length();
//                    return i;
//                };
//        List<Integer> collect = IntStream.rangeClosed(1, 10)
//                .mapToObj(i -> Integer.valueOf(i))
//                .map(i -> i%2 == 0 ? null : i)
//                .collect(Collectors.toList());
//        collect.removeIf(i -> i == null);
//        collect.removeIf(i -> i == 5);
//        collect.forEach(System.out::println);
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(3);
//        list1.add(9);
//        System.out.println(collect.containsAll(list1));

        String[] strings = {"m","e","f","o"};
        Arrays.sort(strings,String::compareToIgnoreCase);
        Arrays.stream(strings).forEach(System.out::println);


    }
}
