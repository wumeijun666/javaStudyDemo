package javaBase;

public class Test {
	public static void main(String[] args) {
		Object o = new Test();//对象的超类的超类的向上转型
		System.out.println(o instanceof Test);  //  true
		//o.show(); //无法使用
		Test t = (Test) o;      //对象的超类的向下转型
//        Test1 t1 = (Test1) t;
        int a =2;
        char c = (char)a;
/*		//t.show(); //无法使用
		Test1 t1 = (Test1) t;   //对象类本身的向下转型
		t1.show(); //可以使用
		System.out.println(t1 instanceof Test);//false
		//Other ot = (Other) t1;  //报错：ClassCastException*/
	}

	int t = 0;
}

class Other
		extends Test1   //删掉时程序7行语法报错
{

}

class Test1 extends Test {
	public void show() {
		System.out.println("我是test1类特有的方法");
	}
}
