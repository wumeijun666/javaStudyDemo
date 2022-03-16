package dict;

public class Test
{
	public static void main(String[] args) {
		WeekDay day  = WeekDay.MON;
		if (day.dayValue == 6 || day == WeekDay.SUN) {
			System.out.println("Work at home!");
		} else {
			System.out.println("Work at office!");
		}
		System.out.println(WeekDay.SUN.name());
		System.out.println(WeekDay.SUN.ordinal());
//		Format.parseObject();
	}
}


