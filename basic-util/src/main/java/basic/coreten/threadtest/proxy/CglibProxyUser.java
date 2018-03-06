package basic.coreten.threadtest.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**Cglib代理测试
 * @author ying
 */
public class CglibProxyUser implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理类开始");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB代理类结束");
        return o1;
    }

    public Object getCGLIBProxyUser(Object object){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(object.getClass());
        return  enhancer.create();

    }
}
