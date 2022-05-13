package fanxing.reflect;

import java.lang.reflect.Constructor;

public class ConstructorReflect {
	public static void main(String[] args) throws Exception {
		// 获取构造方法Integer(int):
		Constructor cons1 = Integer.class.getConstructor(int.class);
		// 调用构造方法:
		Integer n1 = (Integer) cons1.newInstance(123);
		System.out.println(n1);

		// 获取构造方法Integer(String)
		Constructor cons2 = Integer.class.getConstructor(String.class);
		Integer n2 = (Integer) cons2.newInstance("456");
		System.out.println(n2);

		Constructor<Person4> constructor = Person4.class.getConstructor(String.class,Integer.class);
		Object zs = constructor.newInstance("zs", 12);
		System.out.println(zs);
	}
}

class Person4 {
	public String name;
	public Integer age;
	public Person4(String name,Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person4{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
