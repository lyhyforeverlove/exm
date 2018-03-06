package basic.coreten.threadtest.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**cglib代理类测试
 * @author ying
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public CglibProxy(Object o){
        this.target = o;
    }

    public Object getCglibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("--- before ---");
        System.out.println("--- " + methodProxy.getSuperName() + " ---");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("--- after ---");
        return o1;
    }
}
