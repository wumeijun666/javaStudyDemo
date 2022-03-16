import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


class MyHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.print("反射 : " + proxy);
		System.out.print("call : " + method.getName());
		System.out.print("参数 : " + args);
		return null;
	}

}
class A{

	public static void main(String[] args){
		MyInterface myInterface = (MyInterface) Proxy.newProxyInstance(
				MyInterface.class.getClassLoader(),
				new Class[]{MyInterface.class},
				new MyHandler());
		myInterface.test(2,4);
	}
}



interface MyInterface{
	void func();
	void test(int a,int b);
}
