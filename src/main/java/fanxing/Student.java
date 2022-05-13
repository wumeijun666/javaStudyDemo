package fanxing;

public class Student<T> {
	private T name;

	public Student(T name, T lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	public boolean compareToEquals(T t) {
		return this == t;
	}
	private T lastName;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public T getLastName() {
		return lastName;
	}

	public void setLastName(T lastName) {
		this.lastName = lastName;
	}

	public static <T> Student<T> create(T first, T last) {
		return new Student<T>(first, last);
	}

	public static void main(String[] args) {
		Student<String> sts = new Student<>("zs", "ls");
		Student<Integer> sts2 = new Student<>(12, 13);
//		局限一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型：
//		Student<int> sts2 = new Student<>(12, 13);
//		局限二：无法取得带泛型的Class。观察以下代码：
		Class T1 = sts.getClass();
		Class T2 = sts.getClass();
		System.out.println(T1 == T2);
		System.out.println(T1==Student.class); // true
//		因为T是Object，我们对Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class，也就是Pair类的Class。
//		换句话说，所有泛型实例，无论T的类型是什么，getClass()返回同一个Class实例，因为编译后它们全部都是Pair<Object>。


//		局限三：无法判断带泛型的类型：
		Student<Integer> p = new Student<>(123, 456);
		// Compile error:
//		if (p instanceof Student<Integer>) {
//		}

		Student<Integer> p1 = new Student<>(123, 456);
		int sum = PairHelper.add(p1);
		System.out.println(sum);
		Number x = p.getLastName();
		Integer xy = p.getName();
	}
}


class PairHelper {
	static int add(Student<? extends  Number> p) {
		Number first = p.getName();
		Number last = p.getLastName();
		return first.intValue() + last.intValue();
	}
//	static int add(Student<Integer> p) {
//		Number first = p.getName();
//		Number last = p.getLastName();
//		return first.intValue() + last.intValue();
//	}
}
