package fanxing.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//Proxy
public class MyHandler implements InvocationHandler {
    // 标识被代理类的实例对象
    private Object delegate;

    // 构造器注入被代理对象
    public MyHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println(this.delegate.getClass().getName());
        System.out.println("被代理方法调用前的附加代码执行~ ");
        method.invoke(delegate, args);
        System.out.println("被代理方法调用后的附加代码执行~ ");
        return null;
    }
}
