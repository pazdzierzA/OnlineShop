package threads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionTask implements Runnable {
	private final static Logger logger = LogManager.getLogger(ConnectionTask.class.getName());
	private final ConnectionPool pool;
	private final String threadName;

	public ConnectionTask(ConnectionPool pool, String threadName) {
		this.pool = pool;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {
			logger.info(threadName + " trying to acquire connection...");
			MockConnection connection = pool.getConnection();
			Thread.sleep(2000);
			release(connection);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.error("Error", e);
		}

	}
	private void release(MockConnection connection) {
		pool.releaseConnection(connection);
		
	}

	public static final void start() {
		logger.info("ConnectionTask");
		ExecutorService executor = Executors.newFixedThreadPool(7);
		ConnectionPool pool = ConnectionPool.getInstance(5);

		for (int i = 1; i <= 7; i++) {
			executor.submit(new ConnectionTask(pool, "Thread-" + i));
		}
		executor.shutdown();
		try {
			// Wait for the tasks to complete before proceeding
			if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
		pool.shutdown();
		logger.info("All tasks completed.");

	}
}
