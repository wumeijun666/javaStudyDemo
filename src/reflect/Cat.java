package reflect;

import groovy.transform.builder.Builder;

import java.io.Serializable;

/***
 * 反射定义：即在运行状态中，对于任意一个类，都能够知道这个类的所以属性和方法；对于任意一个对象，都能调用它的任意一个方法和属性。这种动态获取信息及动态调用对象方法的功能叫Java的反射机制。
 * 因此调用方法时可以忽略权限检查，它可以访问私有得方法和属性，因此可能会破坏封装性而导致安全问题。
 * 反射 能得到类得属性和方法，一般不用反射研究静态的方法和属性。对于静态方法和属性是编译期间通过类就能得到的，反射是动态创建的，对于静态的不需要反射去管理。
 */
@Builder
public class Cat extends Animal<String> implements Cloneable, Serializable {
	public String name;
	private int age;

	public void call() {
		System.out.println("miao miao miao");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
