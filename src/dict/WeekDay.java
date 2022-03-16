package dict;

public enum WeekDay {
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);
	public int dayValue;

	private WeekDay(int dayValue) {
		this.dayValue = dayValue;
	}
}
