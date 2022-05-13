package cglibTestxinda;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibUtilVersion2 implements MethodInterceptor {
	public static   <T> T getProxy(Class<T> cls) {
		// 创建动态代理增强类
		Enhancer enhancer = new Enhancer();
		// 设置类加载器
		enhancer.setClassLoader(cls.getClassLoader());
		// 设置被代理类
		enhancer.setSuperclass(cls);
		// 设置方法拦截器  这样又创建一个新的工具类，这种方式不是很好 不建议这样做，请使用第三版本的工具类
		enhancer.setCallback(new CglibUtilVersion2());
		// 创建代理类
		return (T) enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		APISpec aClass = method.getDeclaredAnnotation(APISpec.class);
		System.out.println(aClass.code());
		before(method.getName());
		methodProxy.invokeSuper(o, args);
		after(method.getName());
		return null;
	}

	public void before(String name) {
		System.out.println("调用：" + name + "f方法前");
	}

	public void after(String name) {
		System.out.println("调用：" + name + "f方法后");
	}
}
