package fanxing.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringReflect {
	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		String s = "Hello world";
//		String r = s.substring(6); // "world"
		Class strCls = s.getClass();
		Method m = strCls.getMethod("substring", int.class);
		String str = (String) m.invoke(s, 6);
		System.out.println(str);

//		Integer.parseInt("22");
		Method m2 = Integer.class.getMethod("parseInt", String.class);
		int res = (int) m2.invoke(null, "22");
		System.out.println(res);

		Person3 p3 = new Person3();
		Class<? extends Person3> aClass = p3.getClass();
		Method m3 = aClass.getDeclaredMethod("setName", String.class);
		m3.setAccessible(true);
		m3.invoke(p3, "zs");
		System.out.println(p3.name);
	}
}

class Person3 {
	String name;

	private void setName(String name) {
		this.name = name;
	}
}
