package javaBase;

public class JavaMagicNumber {
	public static void main(String[] args) {
//		有些时候，类型的名字太长，写起来比较麻烦
		StringBuilder sb = new StringBuilder();
//		这个时候，如果想省略变量类型，可以使用var关键字
		var sb2 = new StringBuilder();

		// 浮点数比较
		double c = 1.02d;
		double d = 1.02;
		double result = Math.abs(c-d);
		if(result<0.0001){
			System.out.println("比较相等");
		}else{
			System.out.println("比较不相等");
		}
		System.out.println(c==d);
	}
}
