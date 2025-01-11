package threads;
public abstract class Connection {
	private final String id;

	public Connection(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public abstract void connect();

	public abstract void disconnect();
}
