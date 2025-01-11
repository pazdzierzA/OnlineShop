package threads;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableThread implements Runnable {
	private final static Logger logger = LogManager.getLogger(RunnableThread.class.getName());
	
	public RunnableThread() {
	}
	
	@Override
	public void run() {
		logger.info("Runnable Thread is running...");

	}
}