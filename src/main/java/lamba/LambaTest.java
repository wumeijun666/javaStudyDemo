package lamba;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class LambaTest {
	public static void main(String[] args) {
		List<String> itemList = new ArrayList<>();
		itemList.add("Eric");
		itemList.add("CoderGeshu");
		itemList.add("seven1");
		System.out.println(itemList);
		Stream<String> stringStream = itemList.stream().sorted((s1, s2) -> s2.length() - s1.length()).parallel();
		assertTrue(stringStream.isParallel());
//		System.out.println(strs);
	}
}
