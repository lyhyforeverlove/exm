package basic.test.List;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public interface Test_List {

    Integer getAge(String name);

    String getName(Integer id);
//    String getName();

    //默认方法
    default String getName(){
        return "nihao!";
    }
    //静态工厂方法
    public static <T> List<T> nCopies(int num,T t) throws Exception{
        List<T> list = new ArrayList<>();
        for (int i = 0 ;i < num; i++) {
            T o = (T)Class.forName(t.getClass().getCanonicalName()).newInstance();
            list.add(o);
        }
        return list;
    }


}

