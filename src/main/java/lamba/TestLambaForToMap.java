package lamba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestLambaForToMap {
    public static void main(String[] args) {
        // 名字相同的对象年龄累加
        List<Student> students = new ArrayList<>() {{
            add(new Student(12, "zs"));
            add(new Student(13, "ls"));
            add(new Student(14, "ww"));
            add(new Student(15, "zs"));
        }};
        Map<String, Student> collect = students.stream().collect(Collectors.toMap(Student::getName, a -> a, (s1, s2) -> {
            s1.setAge(s1.getAge() + s2.getAge());
            return s1;
        }));
        System.out.println(collect);
        List<Student> studes = students.stream().collect(Collectors.toMap(Student::getName, a -> a, (s1, s2) -> {
            s1.setAge(s1.getAge() + s2.getAge());
            return s1;
        })).values().stream().collect(Collectors.toList());
        System.out.println(studes);
    }
}
