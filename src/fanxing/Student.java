package fanxing;

public class Student<T> {
	private T name;

	public Student(T name, T lastName) {
		this.name = name;
		this.lastName = lastName;
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
		Class T1 = sts.getClass();
		Class T2 = sts.getClass();
		System.out.println(T1 == T2);
	}
}
