package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionTaskFuture implements Runnable {
	private final static Logger logger = LogManager.getLogger(ConnectionTaskFuture.class.getName());
	private final ConnectionPool pool;
	private final String threadName;
	private final CompletableFuture<Void> future;

	public ConnectionTaskFuture(ConnectionPool pool, String threadName, CompletableFuture<Void> future) {
		this.pool = pool;
		this.threadName = threadName;
		this.future = future;
	}

	CompletableFuture<Void> getFuture() {
		return future;
	}

	@Override
	public void run() {
		try {
			logger.info(threadName + " trying to acquire connection...");
			MockConnection connection = pool.getConnection();
			Thread.sleep(4000); 
			release(connection);
			future.complete(null);// Complete the CompletableFuture when the task is done
		} catch (InterruptedException e) {
			logger.error("Error", e);
		} 
	}
	
	
	private void release(MockConnection connection) {
		pool.releaseConnection(connection);
		
	}
	public static final void start() {
		logger.info("ConnectionTaskFuture");
		ExecutorService executor = Executors.newFixedThreadPool(7);
		ConnectionPool pool = ConnectionPool.getInstance(5);
		List<CompletableFuture<Void>> futures = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
			CompletableFuture<Void> future = new CompletableFuture<>();
			futures.add(future);
			executor.submit(new ConnectionTaskFuture(pool, "Thread-" + i, future));
		}
		CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
		try {
			allOf.join(); // This will block until all tasks are completed
		} catch (Exception e) {
			logger.error("Error", e);
		}
		executor.shutdown();
		logger.info("All tasks completed.");
	}

}