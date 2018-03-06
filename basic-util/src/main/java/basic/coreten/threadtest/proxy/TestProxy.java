package basic.coreten.threadtest.proxy;

public class TestProxy {

    public static void main(String[] args) {

        //JDK代理
//        UserService proxy = (UserService)new ProxyUser(new UserServiceImpl()).getProxy();
//        proxy.getName("hello");
//        proxy.getAge();

        //CGLIB代理：接口类接收测试
//        UserService cglibProxy = (UserService)new CglibProxy(new UserServiceImpl()).getCglibProxy();
//        cglibProxy.getName("hello");
//        cglibProxy.getAge();

        //CGLIB代理：实现类接收测试
        CglibProxyUser cpu = new CglibProxyUser();
        UserServiceImpl userService = (UserServiceImpl)cpu.getCGLIBProxyUser(new UserServiceImpl());
        userService.getAge();
        userService.getName("123");
        //调用原来的方法，没有经过处理
        userService.getAddress();
        userService.getAddressNo();

    }

}
