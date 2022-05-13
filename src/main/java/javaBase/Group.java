package javaBase;

import java.util.Arrays;

public class Group {
    private String[] names;

    public void setNames(String... names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }

    public static void main(String[] args) {
        Group g = new Group();
        g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
//        g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
//        g.setNames("Xiao Ming"); // 传入1个String
//        g.setNames(); // 传入0个String
        System.out.println(Arrays.toString(g.getNames()));
    }
}
