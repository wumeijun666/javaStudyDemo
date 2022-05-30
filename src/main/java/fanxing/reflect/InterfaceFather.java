package fanxing.reflect;

public class InterfaceFather {
	public static void main(String[] args) {
		Class<? super A> superclass = A.class.getSuperclass();
		System.out.println(superclass);
		Class<?>[] interfaces = A.class.getInterfaces();
		for (Class<?> anInterface : interfaces) {
			System.out.println(anInterface);
		}
	}
}

abstract class C {

}
interface D {

}
class A extends C  implements D {

}

class B extends A {

}
