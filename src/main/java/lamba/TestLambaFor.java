package lamba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author Seven Wu
 *
 */
public class TestLambaFor {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>() {{
			add(new Student(12, "zs"));
			add(new Student(13, "ls"));
			add(new Student(14, "ww"));
			add(new Student(15, "zl"));
		}};
		List<Student> students2 = new ArrayList<>() {{
			add(new Student(13, "ls"));
			add(new Student(14, "ww"));
		}};

/*		List<Student>  results = students.stream().filter(s -> {
			return s.age > 13;
		}).collect(Collectors.toList());
		System.out.println(results);*/
		//获取两个集合中元素相同的值
		List<Student> results = students.stream().filter(student -> students2.stream().filter(s2 -> s2.getName().equals(student.getName())).findAny().isPresent()).collect(Collectors.toList());

		System.out.println(results);

		Student zs = students.stream().filter(s2 -> "zs".equals(s2.getName())).findAny().get();
		System.out.println("zs=" + zs);
		// Creating a List of Strings
		List<String> list = Arrays.asList("aaa", "for",
				"GeeksQuiz", "GFG");

		// Using Stream findAny() to return
		// an Optional describing some element
		// of the stream
		Optional<String> answer = list.stream().parallel().findAny();

		// if the stream is empty, an empty
		// Optional is returned.
		if (answer.isPresent()) {
			System.out.println(answer);
			System.out.println(answer.get());
		}
		else {
			System.out.println("no value");
		}
	}
}

class Student {
	int age;
	String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}
