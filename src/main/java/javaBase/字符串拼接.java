package javaBase;

import java.util.StringJoiner;

public class 字符串拼接 {
	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner("-");
		String s = "";
		for (int i = 0; i < 2; i++) {
			sj.add(i + "");
		}
		System.out.println(sj.toString());
	}
}
