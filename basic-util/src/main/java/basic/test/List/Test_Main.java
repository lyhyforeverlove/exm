package basic.test.List;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Test_Main {


    public static void main(String[] args) throws Exception {
        //接口默认方法测试
//        Test_List impl = new Test_List_impl();
//        System.out.println(impl.getName((int)1));
//        System.out.println(impl.getName());
        //接口静态工厂方法测试
//        List<String> list = Test_List.nCopies(5, "nihao");
//        System.out.println("---> :" + JSON.toJSONString(list));
        //测试默认方法作为接口的重写方法
        Test_List_impl2 test_list_impl2 = new Test_List_3();
        System.out.println(test_list_impl2.getAge(""));
    }

}
