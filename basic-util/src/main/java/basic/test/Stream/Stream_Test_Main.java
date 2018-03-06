package basic.test.Stream;

import basic.test.Model.Person;
import basic.test.Model.WorkPlace;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Test_Main {


    public static List<Integer> assembleList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        List<Integer> integers = assembleList();
//        System.out.println(integers.stream().filter(i -> i.intValue()%5 == 0 ).count());
//        System.out.println("完成时间：" + (System.currentTimeMillis() - start));
        //字符串按照长度排序：从小到大
//        String[] strLength = {"hello", "ni", "sb", "shi", "hahahahah"};
//        Stream<String> hello = Arrays.stream(strLength);
//        hello.sorted(Comparator.comparing(String::length))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

//        Arrays.stream(strLength)
//                .parallel()
//                .filter(w -> w.startsWith("h"))
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

//        boolean h = Arrays.stream(strLength)
//                .parallel().anyMatch( w -> w.contains("h"));
//        System.out.println("---> :" + h);
//        boolean h2 = Arrays.stream(strLength)
//                .parallel().allMatch(w -> w.contains("h"));
//        System.out.println("---> :" + h2);

//        List<Integer> integers = new ArrayList<>();
//        for (int i = 1; i <= 100; i++) {
//            integers.add(i);
//        }
//        Stream<Integer> stream = integers.parallelStream();
//        //等于 stream.reduce(Integer::sum)
//        Optional<Integer> reduce = stream.reduce((x, y) -> x + y);
//        Integer integer = reduce.orElse(0);
//        System.out.println("--->: " + integer);

//        int sum = Arrays.stream(strLength).mapToInt(String::length).sum();
//        System.out.println(sum);

//        TreeSet<Integer> collect = integers.stream().collect(Collectors.toCollection(TreeSet::new));
//        collect.forEach(System.out::println);

//        String collect = Arrays.stream(strLength).collect(Collectors.joining());
//        String collect1 = Arrays.stream(strLength).collect(Collectors.joining(", "));
//        System.out.println(collect1);
        List<Person> people = new ArrayList<>();
        Random random = new Random();
        //利用IntStream来创建集合元素
//        for (int i = 0; i < 5; i++) {
//            Person p = new Person();
//            p.setId(i + random.nextInt(10));
//            p.setName("test" + random.nextInt(10));
//            p.setAge(i + 10);
//            people.add(p);
//        }
        //利用IntStream来创建集合元素:同上
        IntStream.rangeClosed(1,5)
                .mapToObj(i -> new Person(i + random.nextInt(10),"test" + i,i +10))
        .forEach(people::add);

        //利用IntStream来创建集合元素
        List<Person> collect1 = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new Person(i + random.nextInt(10), "test"
                        + random.nextInt(10), i + 10))
                .peek(j -> IntStream.rangeClosed(1, 3)
                        .mapToObj(i -> new WorkPlace("work <- 工作地点" + i
                                , j.getFirstName() + "的工作地方！"))
                        .forEach(j.getWorkPlaces()::add))
                .collect(Collectors.toList());
//                .flatMap(f -> f.getWorkPlaces().stream())
//                .forEach(System.out::println);

        //简单使用Optional
//        Optional.of(new Person(100,"test",10
//                ,IntStream.range(1,3)
//                .mapToObj(i -> new WorkPlace("test" + i,"地址" + i)).collect(Collectors.toList())))
//                .flatMap(p -> Optional.ofNullable(p.getWorkPlaces())).ifPresent(System.out::println);


//        Map<Integer, List<Person>> collect = people.parallelStream().collect(Collectors.groupingBy(p -> p.getId()));
//        Map<Integer, List<String>> collect1 = people.stream().collect(Collectors.groupingBy(
//                  ::getId,Collectors.mapping(Person::getName, Collectors.toList())));
//        Map<Integer, String> collect2 = people.stream().collect(Collectors.groupingBy(Person::getId
//                , Collectors.mapping(Person::getName, Collectors.joining("&&"))));
//        collect.entrySet().parallelStream().forEach(System.out::println);
//        collect1.entrySet().stream().forEach(System.out::println);
//        collect2.entrySet().stream().forEach(System.out::println);
//        Map<Integer, Long> collect = people.stream().collect(Collectors.groupingBy(p -> p.getId(), Collectors.counting()));
//        Map<Integer, Set<Person>> collect = people.stream().collect(Collectors.groupingBy(Person::getId, Collectors.toSet()));
//        Map<Integer, String> stringMap = people.stream().collect(Collectors.toMap(p -> p.getId(),p1-> p1.getName()));
//        int sum = stringMap.entrySet().stream().mapToInt(s -> s.getKey()).sum();
//        System.out.println(sum);

//        Stream<Integer> boxed = IntStream.rangeClosed(people.get(0).getId(), people.get(1).getId()).boxed();
//        LongSummaryStatistics lss = boxed.mapToLong(m -> m.longValue()).summaryStatistics();
//        System.out.println("--->:" + lss.getAverage() + ":" + lss.getCount() + ":" + lss.getMax()
//                + ":" + lss.getMin() + ":" + lss.getSum());

//        IntStream ints = new Random().ints((int) 10);
//        ints.forEach(System.out::println);

        //无序截取5个长度的集合片段
//        people.stream().parallel().unordered().limit(5).forEach(System.out::println);

//        people.sort(Comparator.comparing(p -> p.getAge(),(x, y) -> Integer.compare(x,y)));
        people.sort(Comparator.comparingInt(Person::getAge));
        people.forEach(System.out::println);

        Person[] people1 = people.toArray(new Person[people.size()]);
        //第一种年龄倒序
//        Arrays.sort(people1,Comparator.comparing(p -> p.getAge(),Comparator.reverseOrder()));
        //第二种年龄倒序
//        Arrays.sort(people1,Comparator.comparingInt(Person::getAge).reversed());
//        Arrays.stream(people1).forEach(System.out::println);

        //顺序的重要性，sorted放在第一位置会计算所有的元素，但是放在过滤器后面就只计算过滤后的元素；map同样
        Stream.of("d2","a2","b1","b3","c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("b");
                }).sorted((s1,s2) -> {
            System.out.printf("sort: %s; %s\n",s1,s2);
            return s1.compareTo(s2);
        }) .map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        }).forEach(s -> {
            System.out.println("forEach: " + s);
        });

        //int类型的个数，总数，最小，平均，最大值
//        IntSummaryStatistics summaryStatistics = people.stream().collect(Collectors.summarizingInt(p -> p.getAge()));
//        System.out.println("--->: " + summaryStatistics);

        //根据条件字符串拼接
//        String collect = people.stream().filter(p -> p.getAge() >= 12)
//                .map(p -> p.getName())
//                .collect(Collectors.joining(" and In "));
//        System.out.println("--->: " + collect);
//
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//        System.out.println(forkJoinPool.getParallelism());

    }


}
