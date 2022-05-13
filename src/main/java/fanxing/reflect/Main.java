package fanxing.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student s = new Student(12, 2, "zs");
        Class stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));
        System.out.println(Arrays.toString(stdClass.getDeclaredFields()));
        // 获取字段的值
        Field field = stdClass.getDeclaredField("grade");
        field.setAccessible(true);
        Object o = field.get(s);
        System.out.println(o);
    }
}

class Student extends Person {
    public int score;
    private int grade;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(int score, int grade, String name) {
        super(name);
        this.score = score;
        this.grade = grade;
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
