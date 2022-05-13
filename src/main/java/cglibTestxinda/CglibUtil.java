package cglibTestxinda;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibUtil implements MethodInterceptor {
//	public static <T> T load(T targetObj) {
//		return null;
//	}

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
