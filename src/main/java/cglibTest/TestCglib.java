package cglibTest;


import net.sf.cglib.proxy.Enhancer;

public class TestCglib {

	public static void main(String[] args) {
		// 通过CGLIB动态代理获取代理对象的过程
		// 创建Enhancer对象，类似于JDK动态代理的Proxy类
		Enhancer enhancer = new Enhancer();
		// 设置目标类的字节码文件
		enhancer.setSuperclass(TargetObject.class);
		// 设置回调函数
		enhancer.setCallback(new TargetInterceptor());
		TargetInterceptor targetInterceptor = new TargetInterceptor();
		// create方法正式创建代理类
		TargetObject targetObject = (TargetObject) enhancer.create();
		System.out.println(targetObject);
//		System.out.println(targetObject.method1("mmm1"));
//		System.out.println(targetObject.method2(100));
//		System.out.println(targetObject.method3(200));

	}
}
