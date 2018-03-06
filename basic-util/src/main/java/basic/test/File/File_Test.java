package basic.test.File;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class File_Test {

    public static void main(String[] args) throws Exception{

        File file = new File("C:/Users/ying/Desktop/工作日报/工作日报11月.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)
                ,Charset.forName("gbk")));
        Stream<String> lines = bufferedReader.lines();
        lines.forEach(System.out::println);
//
//        String absoluPath = "C:/Users/ying/Desktop/工作日报/工作日报11月.txt";
//        String absoluPath2 = "C:/Users/ying/Desktop/工作日报/工作日报12月.txt";
//        Path path2 = Paths.get(absoluPath2);
//        Path path = Paths.get(absoluPath);
//        System.out.println(path.getParent());
//        System.out.println(path.getRoot());
//        System.out.println(path.toAbsolutePath());
//
//        List<String> list = Files.readAllLines(path.toAbsolutePath(), Charset.forName("gbk"));
//        list.forEach(System.out::println);
        //写入到其他文件
//        Files.write(path2,list);
//        List<String> list1 = Files.readAllLines(path2, Charset.defaultCharset());
//        list1.forEach(System.out::println);

        String absoluPath3 = "C:\\Users\\ying\\Desktop\\工作日报\\工作日报12月.txt";
        String absoluPath4 = "C:\\Users\\ying\\Desktop\\新建文件夹\\工作日报12月.txt";
        //移动复制
//        Path copy = Files.copy(Paths.get(absoluPath3), Paths.get(absoluPath4)
//                , StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
//        System.out.println(copy);
        Path move = Files.move(Paths.get(absoluPath3), Paths.get(absoluPath4), StandardCopyOption.ATOMIC_MOVE);
        System.out.println(move);
        //删除
//        Files.deleteIfExists(Paths.get(absoluPath4));


    }
}
