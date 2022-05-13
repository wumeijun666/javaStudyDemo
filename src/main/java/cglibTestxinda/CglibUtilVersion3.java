package cglibTestxinda;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibUtilVersion3 implements MethodInterceptor {
	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	//	private static class CglibUtilVersionFactory {
	private static CglibUtilVersion3 instance = new CglibUtilVersion3();
//	}

	public static <K> K load(K targetObj) {
		CglibUtilVersion3 versionObj = instance;
		versionObj.setTarget(targetObj);
		return (K) instance.getProxy();
	}

	public Object getProxy() {
		// 创建动态代理增强类
		Enhancer enhancer = new Enhancer();
		// 设置类加载器
		enhancer.setClassLoader(target.getClass().getClassLoader());
		// 设置被代理类
		enhancer.setSuperclass(target.getClass());
		// 设置方法拦截器
		enhancer.setCallback(instance);
//		enhancer.setCallback(this);
		// 创建代理类
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		APISpec aClass = method.getDeclaredAnnotation(APISpec.class);
		System.out.println(aClass.code());
		before(method.getName());
		// 以下两种都可以 请注意传入的第一个参数
//		methodProxy.invokeSuper(o, args);
		methodProxy.invoke(target, args);
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
