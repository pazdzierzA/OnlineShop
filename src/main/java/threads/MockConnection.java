package threads;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class MockConnection extends Connection {
	private final static Logger logger = LogManager.getLogger(MockConnection.class.getName());

	public MockConnection(String id) {
		super(id);
	}

	@Override
	public void connect() {
		logger.info("MockConnection " + getId() + " is now active.");
	}

	@Override
	public void disconnect() {
		logger.info("MockConnection " + getId() + " is now closed.");
	}
}
