package threads;

public class ThreadMain {

	public static final void main(String[] args) {
		
		// create 2 threads
		RunnableThread myRunnable = new RunnableThread();
		Thread runnableThread = new Thread(myRunnable);
		Thread thread = new Thread();
		
		
		//Deadlock.start();
		//ConnectionTask.start();
		ConnectionTaskFuture.start();
	}
}