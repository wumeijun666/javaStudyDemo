package fanxing.reflect;
//client
public class Client1 {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		UserService proxy = new UserServiceProxy(userService);
		proxy.select();
		proxy.update();
	}
}
