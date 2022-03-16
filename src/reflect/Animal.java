package reflect;

public  abstract class Animal<T> {
	public String type;
	public abstract void call();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
