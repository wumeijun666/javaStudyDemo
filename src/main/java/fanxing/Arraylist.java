package fanxing;

import java.util.Date;

class Arraylist<E> {
    private Object[] elementData;
    private int size = 0;

    public Arraylist(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public boolean add(E e) {
        elementData[size++] = e;
        return true;
    }

//    public static void method(Arraylist<String> list) {
//        System.out.println("Arraylist<String> list");
//    }

    public static void method(Arraylist<Date> list) {
        System.out.println("Arraylist<Date> list");
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    public static void main(String[] args) {
        Arraylist<String> list = new Arraylist<String>(2);
        list.add("沉默王三");
        String str = list.elementData(0);
        System.out.println(str);
    }
}
