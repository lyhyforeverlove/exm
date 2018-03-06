package basic.test.Model;

public interface TestService {


    default String getAge(String name){
        return getName(name);
    }

    public static String getName(String name){
        return name;
    }

}
