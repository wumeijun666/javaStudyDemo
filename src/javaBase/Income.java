package javaBase;

public class Income {
	double sal;

	public Income(double sal) {
		this.sal = sal;
	}

	public double getTax() {
		return sal * 0.1;
	}

	public static void main(String[] args) {
		Income[] incomes = new Income[]{
				new Income(3000),
				new StudnetIncome(2000)
		};
		double total = 0;
		for (Income inc : incomes) {
			total = total + inc.getTax();
		}
		System.out.println(total);
	}
}

class StudnetIncome extends Income {

	public StudnetIncome(double sal) {
		super(sal);
	}

	public double getTax() {
		return sal * 0.2;
	}
}
