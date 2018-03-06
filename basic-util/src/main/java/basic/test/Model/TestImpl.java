package basic.test.Model;

public class TestImpl extends TestAbstractCla implements TestService {


    @Override
    public String getAge() {
        return "10";
    }


    @Override
    public String getAge(String name) {
        return "name: " + name;
    }
}
