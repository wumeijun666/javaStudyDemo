package reflect.utils;

import java.io.IOException;
import java.util.Properties;

public class PropUtils {
	private static final Properties p = new Properties();

	static {
		try {
			p.load(PropUtils.class.getClassLoader().getResourceAsStream("object.properties"));
		} catch (IOException e) {
//			e.printStackTrace();
			throw new ExceptionInInitializerError("加载配置文件失败");
		}

	}

	public static String getProperties(String key) {
		return p.getProperty(key);
	}
}
