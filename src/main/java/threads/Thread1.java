package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Thread1 extends Thread {
	private final static Logger logger = LogManager.getLogger(Thread.class.getName());

	public Thread1() {
	}

	public void run() {
		logger.info("Thread class-based thread is running...");
	}
}
