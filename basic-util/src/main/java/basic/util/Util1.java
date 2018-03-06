package basic.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Util1 {

    public static void main(String[] args) {
//        Comparable<String> com = (first) -> Integer.compare(first.length(),5);
//        System.out.println(com.compareTo("fdsaaaa"));
        String[] words = {"a","bc","def"};
//        Arrays.sort(words,(first,second) -> Integer.compare(second.length(),first.length()));
        Collections.sort(Arrays.asList(words),(s,w) -> Integer.compare(w.length(),s.length()));
        Arrays.asList(words).forEach(w -> {
            System.out.println(w);
        });
    }

}
