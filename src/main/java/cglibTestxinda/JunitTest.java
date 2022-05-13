package cglibTestxinda;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class JunitTest {
	@Test
	public void test1() {
		// 创建动态代理增强类
		Enhancer enhancer = new Enhancer();
		// 设置类加载器
		enhancer.setClassLoader(ReceiveMaterialService.class.getClassLoader());
		// 设置被代理类
		enhancer.setSuperclass(ReceiveMaterialService.class);
		// 设置方法拦截器
		enhancer.setCallback(new CglibUtil());
		// 创建代理类
		ReceiveMaterialService receiveMaterialService = (ReceiveMaterialService) enhancer.create();
		receiveMaterialService.receiveMaterial("aaa",11);
	}
	@Test
	public void test2() {
		ReceiveMaterialService proxy = CglibUtilVersion2.getProxy(ReceiveMaterialService.class);
		proxy.receiveMaterial("aaa",11);
	}

	@Test
	public void test3(){
		ReceiveMaterialService load = CglibUtilVersion3.load(new ReceiveMaterialService());
		load.receiveMaterial("aaa",11);
	}
}
