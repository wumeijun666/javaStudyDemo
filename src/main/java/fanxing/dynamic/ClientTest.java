package fanxing.dynamic;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientTest {
	public static void main(String[] args) {
		// 创建被代理的对象
		UserService service = new UserServiceImpl();
		// 创建处理器实现
		InvocationHandler myHandler = new MyHandler(service);
		// 重点！ 生成代理类， 其中proxyA 就是service的代理类了
		UserService proxyA  = (UserService) Proxy.newProxyInstance(service.getClass().getClassLoader(), UserServiceImpl.class.getInterfaces(), myHandler);
		System.out.println(proxyA instanceof Proxy);
		System.out.println("proxyA的Class类是："+proxyA.getClass().toString());
		Field[] field=proxyA.getClass().getDeclaredFields();
		for(Field f:field){
			System.out.println(f.getName()+", ");
		}
		proxyA.select();
	}
}
