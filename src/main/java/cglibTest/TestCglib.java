package cglibTest;


import net.sf.cglib.proxy.Enhancer;

public class TestCglib {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TargetObject.class);
		enhancer.setCallback(new TargetInterceptor());
		TargetInterceptor targetInterceptor = new TargetInterceptor();
		TargetObject targetObject = (TargetObject) enhancer.create();
		System.out.println(targetObject);
		System.out.println(targetObject.method1("mmm1"));
//		System.out.println(targetObject.method2(100));
//		System.out.println(targetObject.method3(200));

	}
}
