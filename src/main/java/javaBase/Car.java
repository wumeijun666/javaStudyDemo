package javaBase;

public class Car {
	public Car() {
		count++;
	}

	static int count = 0;

	public static void main(String[] args) {
		Car c = new Car();
		System.out.println(Car.count);
		Car c2 = new Car();
		System.out.println(Car.count);
	}
}
