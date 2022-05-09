package javaBase;

public class Study {
	public static void main(String[] args) {
		Person1 p = new Person1("小明", 12);
		Student s = new Student("小红", 20, 99);
		// TODO: 定义PrimaryStudent，从Student继承，新增grade字段:
		Student ps = new PrimaryStudent("小军", 9, 100, 5);
		if (ps instanceof PrimaryStudent) {
			PrimaryStudent pp = (PrimaryStudent) ps;
			System.out.println(pp.run("S"));
		}

	}
}

class Person1 {
	protected String name;
	protected int age;

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
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

class Student extends Person1 {
	protected int score;
	public void run() {
	}
	public Student(String name, int age, int score) {
		super(name, age);
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}

class PrimaryStudent extends Student {
	protected int grade;

	public PrimaryStudent(String name, int age, int score, int grade) {
		super(name, age, score);
		this.grade = grade;
	}
	@Override
	public void run() {
	}

	// 不是Override，因为返回值不同:
	public int run(String s) {
		return 2;
	}

	public int getGrade() {
		return grade;
	}
}
