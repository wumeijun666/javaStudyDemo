package lamba;


public interface Displayer {
    void display(String pa);

}

//class DisplayImpl implements Displayer {
//    @Override
//    public void display() {
//        System.out.println("I'm CoderGeshu");
//    }
//}

//class Test {
//    public static void main(String[] args) {
//        Displayer displayer = new DisplayImpl();
//        displayer.display();
//    }
//}

class Test2 {
    public static void main(String[] args) {
        Displayer displayer = e-> System.out.println(e);
        displayer.display("222");
    }
}

