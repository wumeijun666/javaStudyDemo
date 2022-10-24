package hutool.datetest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
//		DateTime date = DateUtil.date();
//		DateTime endOfDay = DateUtil.endOfDay(date);
		String dateStr = "2021-06-21";
		Date date = DateUtil.parse(dateStr);
		DateTime endOfDay = DateUtil.endOfDay(date);
		final DateTime quarterDateTime = DateUtil.endOfQuarter(date);
		int days = (int) ((quarterDateTime.getTime()-date.getTime())/(1000*3600*24));
		long betweenDay = DateUtil.between(endOfDay, quarterDateTime, DateUnit.DAY);
		System.out.println(date);
		System.out.println(endOfDay);
		System.out.println(quarterDateTime);
		System.out.println(days);
		System.out.println(betweenDay);
	}
}
