package reflect;

// https://www.bilibili.com/video/BV1wb4y1v7Fy?p=4&spm_id_from=pageDriver

import org.junit.Test;
import reflect.utils.PropUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class CatTest {
	@Test
	public void testCat() throws Exception {
/*		// 调用猫叫的行为
		Cat c = new Cat("加菲猫");
		c.call();
		// 调用狗的叫行为
		Dog d = new Dog();
		d.call();*/
// 调用动物叫的行为，具体是哪一种动物叫,那么需要在程序运行阶段确定的。
// 通过写一个配置文件，读取配置参数，模拟在运行时创建对象。

		/**
		 *   通过类加载机制， 加载 类 ，从而获取 类对象
		 *   类对象 ： 我们定义的Dog类 Cat类这些类 也有自己的父级类型，我们把这种类型叫类对象
		 *    获取类对象的方式有三种
		 *    1 类.class
		 *    2 obj.getClass()
		 *   3   Class.forName("类的名字")
		 *
		 *    <?> 等价于 <? extends Object>
		 * */
		String className = PropUtils.getProperties("animal");
//		Class clz = Dog.class;   类.class
//		Cat c = new Cat();
//		Class  clz = c.getClass();  obj.getClass()

		//		类对象 可以创建 类的 对象
		Class<?> clz = Class.forName(className);

		// 构造方法对象
		Constructor<?> constructor = clz.getConstructor();
		// 通过构造方法对象 创建类的 对象
		Animal animal = (Animal) constructor.newInstance();
		animal.call();
	}

	// 获取类对象的三种方式,不管哪种方式 得到的最终都是同一个类对象
	@Test
	public void testGetClass() throws ClassNotFoundException {
		// 通过 类 获取 类对象
		Class<Cat> catClass = Cat.class;
		// 通过 对象的方式 获取 类对象
		Cat cat = new Cat();
		Class<? extends Cat> aclass = cat.getClass();
		//通过 类的名字 获取 类对象   <?> 等价于 <? extends Object>
		Class<? extends Object> aClass1 = Class.forName("reflect.Cat");
		/**
		 * 类对象：是类加载的产物
		 * 类加载： JVM 第一次读取一个类的时候，将类的字节码文件加载到内存的过程
		 * **/
		System.out.println(catClass == aclass);
		System.out.println(aClass1 == aclass);
	}

	/***
	 * java中 加载一个类，主要通过 ‘双亲委托机制’ 来实现的加载
	 * 双亲委托机制：加载类委托我的父类，而我的父类又委托我父类的父类取加载
	 */
	@Test
	public void testClassForName() {
		System.out.println(this.getClass().getClassLoader());// 系统加载器System ClassLoader
		System.out.println(this.getClass().getClassLoader().getParent());// 扩展加载器 Extension ClassLoader
		System.out.println(this.getClass().getClassLoader().getParent().getParent()); // 底层的不给看 Bootstrap ClassLoader
	}

	@Test
	public void testClassForName2() throws ClassNotFoundException {
		Class<?> catClass = Class.forName("reflect.Cat");
		System.out.println(catClass);
	}

	/**
	 * 获取类相关的信息
	 */
	@Test
	public void testClass() {
		// 获取 猫类的类对象
		Class<Cat> catClass = Cat.class;
		// 获取 该 类的加载器
		System.out.println(catClass.getClassLoader());
		// 获取 类的 类名
		System.out.println(catClass.getName());
		System.out.println(catClass.getSimpleName());
		System.out.println(catClass.getPackageName());
		// 获取 该类的 父类
		Class<? super Cat> superclass = catClass.getSuperclass();
		System.out.println(superclass.getName());

		// 获取 该类的 带泛型父类
		ParameterizedType genericSuperclass = (ParameterizedType) catClass.getGenericSuperclass();
		System.out.println(genericSuperclass.getTypeName());
		Type actualTypeArgument = genericSuperclass.getActualTypeArguments()[0];
		System.out.println(actualTypeArgument);

		// 获取该类实现的接口
		Class<?>[] interfaces = catClass.getInterfaces();
		System.out.println(Arrays.toString(interfaces));
		// 获取带泛型的接口对象
		Type[] genericInterfaces = catClass.getGenericInterfaces();
		// 获取类的注解
		Annotation[] annotation = catClass.getAnnotations();
		System.out.println(Arrays.toString(annotation ));
		String s= "a";

	}
	/**
	 * 获取类的组成部分：比如属性
	 * */
	@Test
	public void testClassField() throws Exception{
		// 获取类的类对象
		Class<Cat> clz = Cat.class;
		// 获取 猫类中定义的 公共属性，包括父类中公共的属性
		Field[] fields = clz.getFields();
		System.out.println(Arrays.toString(fields));
		// 获取 猫类中声明的 所有属性 （不包含父类中定义的属性）
		Field[] declaredFields = clz.getDeclaredFields();
		System.out.println(Arrays.toString(declaredFields));
		//在运行期间 获取 猫类中的 type 属性(父类的和自己的公共属性）
		Field nameField = clz.getField("type");
		System.out.println(nameField);
		//在运行期间 获取 猫类中的 name 属性（只能是自己的公共属性，不包括父类的）
		Field name = clz.getDeclaredField("name");
		System.out.println(name);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	}
}
