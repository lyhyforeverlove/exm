package basic.test.Sundry;

import basic.test.Model.Person;
import basic.test.Model.TestRepeat;
import sun.nio.cs.ext.GBK;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Sundry_Test_Main {

    public static void main(String[] args) {
//        List<CharSequence> list = new ArrayList<>();
//        for (int i = 0; i < 36; i++) {
//            list.add(String.valueOf(i));
//        }
//        System.out.println(String.join("+",list));
        
//        int x = 3;
//        int y = 10;
//        System.out.println(Math.floorMod(x,y));
//        System.out.println(x % y);

//        Integer a = 5;
//        Integer b = 5;
//        Integer[] array1 = new Integer[]{1,2,3,4,5,6};
//        Integer[] array2 = new Integer[]{1,2,3,4,5,6};
//        System.out.println(Objects.equals(array1,array2));
//        System.out.println(Objects.deepEquals(array1,array2));
//
//        System.out.println(Integer.compare(a,b));
//        System.out.println(Integer.divideUnsigned(a,b));
//        System.out.println(Integer.remainderUnsigned(a,b));
//        System.out.println(Integer.sum(a,b));
//        System.out.println(Integer.rotateLeft(2,2));

//        NumberFormat instance = NumberFormat.getInstance();
//        NumberFormat percentInstance = NumberFormat.getPercentInstance();
//        double x = 0.124;
//        System.out.println(percentInstance.format(x));
//        String test="100,120,166,1555,120,150,100";
//        List<Integer> collect = Arrays.stream(test.split(","))
//                .map(s -> {
//                    int i = Integer.parseInt(s);
//                    System.out.println("map: " + i);
//                    return i;
//                })
//                .collect(Collectors.toSet())
//                .stream()
//                .sorted((x,y) -> {
//                    int i = x.compareTo(y);
//                    System.out.println("sort: " + i);
//                    return i;
//                })
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);
//        ArrayList<Object> list = new ArrayList<>((int)100);
//        如果已经清楚或能够估计出数组可能存储的元素数量， 就可以在填充数组之前调用
//        ensureCapacity方法：
//        staff.ensureCapacity(lOO);
//        这个方法调用将分配一个包含 100 个对象的内部数组。然后调用 100 次 add, 而不用重新分
//        配空间
//        list.ensureCapacity(100);
//        一旦能够确认数组列表的大小不再发生变化，就可以调用 trimToSize方法。这个方法将
//        存储区域的大小调整为当前元素数量所需要的存储空间数目。垃圾回收器将回收多余的存储
//        空间。
//        一旦整理了数组列表的大小，添加新元素就需要花时间再次移动存储块，所以应该在确
//        认不会添加任何元素时， 再调用 trimToSize。
//        list.trimToSize();


    }
}