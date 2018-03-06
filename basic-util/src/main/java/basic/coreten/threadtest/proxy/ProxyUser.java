package basic.coreten.threadtest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**Cglib代理类测试
 * @author ying
 */
public class ProxyUser implements InvocationHandler {

    private Object target;

    public ProxyUser(Object object){
        this.target = object;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法开始前打印---");
        System.out.println("---" + proxy.getClass().getName() + "---");
        Object invoke = method.invoke(target, args);
        System.out.println("方法开始后打印---");
        return invoke;
    }
}
