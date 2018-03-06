package basic.coreten.threadtest.proxy;

public class UserServiceImpl implements UserService {

    @Override
    public String getName(String name) {
        System.out.println(name);
        return name;
    }

    @Override
    public int getAge() {
        System.out.println(0);
        return 0;
    }

    public final String getAddress(){
        System.out.println("adc");
        return "123";
    }
    public String getAddressNo(){
        System.out.println("No:adc");
        return "123";
    }

}
