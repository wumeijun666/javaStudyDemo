package fanxing;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
//		ArrayList<Integer> integerList = new ArrayList<Integer>();
//// 添加一个Integer：
//		integerList.add(new Integer(123));
//// “向上转型”为ArrayList<Number>：
//		ArrayList<Object> numberList = integerList;
//// 添加一个Float，因为Float也是Number：
//		numberList.add(new Float(12.34));
//// 从ArrayList<Integer>获取索引为1的元素（即添加的Float）：
//		Integer n = integerList.get(1); // ClassCastException!
//		Arrays.sort();
		Person[] ps = new Person[]{
				new Person("Bob", 61),
				new Person("Alice", 88),
				new Person("Lily", 75),
		};
		Arrays.sort(ps);
		System.out.println(Arrays.toString(ps));
	}
}

class Person implements Comparable<Person>{
	String name;
	int score;

	Person(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String toString() {
		return this.name + "," + this.score;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
}
