package threads;

import java.util.concurrent.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	private final static Logger logger = LogManager.getLogger(ConnectionPool.class.getName());
	private BlockingQueue<MockConnection> connections;
	private Integer size;
	private static ConnectionPool INSTANCE = null;

	private ConnectionPool(Integer size) {
		this.size = size;
		this.connections = new ArrayBlockingQueue<>(size);
		for (int i = 0; i < size; i++) {
			connections.offer(new MockConnection("Conn-" + (i + 1)));
		}
	}

	public static ConnectionPool getInstance(Integer size) {
		if (INSTANCE == null) {
			INSTANCE = new ConnectionPool(size);
			
		}
		return INSTANCE;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void releaseConnection(MockConnection connection) {
		if (connection != null) {
			logger.info(Thread.currentThread().getName() + " releasing connection: " + connection.getId());
			connections.offer(connection);
			logger.info("Queue state after release: " + connections );
	    }
	}

	public MockConnection getConnection() throws InterruptedException  {
		logger.info(Thread.currentThread().getName() + " waiting for connection... ");
		MockConnection connection = connections.take();
		logger.info(Thread.currentThread().getName() + " acquired connection: " + connection.getId() );
	    logger.info("Queue state after acquire: " + connections );
		return connection;
	}
	
	public void shutdown() {
	        connections.clear();
	        logger.info("Connection pool has been shut down.");
	}
}
