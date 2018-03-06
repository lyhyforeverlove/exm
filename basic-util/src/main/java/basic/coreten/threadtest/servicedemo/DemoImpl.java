package basic.coreten.threadtest.servicedemo;

public class DemoImpl implements DemoSservice {

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public void getName() {

    }
    //2个接口中同样的方法，只有一个实现方法就可以，删除2个接口中的任意一个方法仍然可以
    @Override
    public void get() {

    }

    @Override
    public String getAge() {
        return null;
    }
}
