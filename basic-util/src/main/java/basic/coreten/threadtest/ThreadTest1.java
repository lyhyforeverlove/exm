package basic.coreten.threadtest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class ThreadTest1 {

    public static void main(String[] args) {

//        Thread thread = Thread.currentThread();
//        Thread.State state = thread.getState();
//
//        System.out.println(state);

        JSONObject jsonObject = JSON.parseObject("{'key':'sa','value':[{'vkey':1231},{'vkey':864}]}");
        Map<String,Object> map = jsonObject;
        System.out.println(map.toString());


    }
}
