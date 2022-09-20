package hutool.datetest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		DateTime date = DateUtil.date();
		DateTime endOfDay = DateUtil.endOfDay(date);
//		String dateStr = "2021-06-21";
//		Date date = DateUtil.parse(dateStr);
		final DateTime quarterDateTime = DateUtil.endOfQuarter(date);
		int days = (int) ((quarterDateTime.getTime()-date.getTime())/(1000*3600*24));
		System.out.println(date);
		System.out.println(endOfDay);
		System.out.println(quarterDateTime);
		System.out.println(days);
	}
}
