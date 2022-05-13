package cglibTest;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {

	/**
	 * 重写方法拦截在方法前和方法后加入业务
	 * Object obj为目标对象
	 * Method method为目标方法
	 * Object[] params 为参数，
	 * MethodProxy proxy CGlib方法代理对象
	 */
	public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
		System.out.println("method before");
		Object result = methodProxy.invokeSuper(obj, params);
		System.out.println("method after "+result);
		return result;
	}

}


