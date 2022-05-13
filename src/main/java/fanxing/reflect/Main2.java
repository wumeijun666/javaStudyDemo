package fanxing.reflect;

public class Main2 {
	public static void main(String[] args) throws Exception {
		Class stdClass = Student2.class;
		Class [] obs = new Class[]{String.class, int.class};
		// 获取public方法getScore，参数为String:
		System.out.println(stdClass.getMethod("getScore", obs));
		// 获取继承的public方法getName，无参数:
		System.out.println(stdClass.getMethod("getName"));
		// 获取private方法getGrade，参数为int:
		System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
	}
}

class Student2 extends Person2 {
	public int getScore(String type, int age) {
		age = 1;
		return 99 + age;
	}

	private int getGrade(int year) {
		return 1;
	}
}

class Person2 {
	public String getName() {
		return "Person";
	}
}
