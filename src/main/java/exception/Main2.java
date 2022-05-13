package exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main2 {
	public static void main(String[] args) {
		Log log = LogFactory.getLog(Main2.class);
		log.info("start...");
		log.warn("end.");
	}
}
