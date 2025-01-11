package threads;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Deadlock {
	private final static Logger logger = LogManager.getLogger(Deadlock.class.getName());
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
	
    
    public static void start() {
    	Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                logger.info("Thread1 : Hold lock1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                   logger.info("Thread1 : Hold lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
            	logger.info("Thread2  : Hold lock2");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock1) {
                	logger.info("Thread2 : Hold lock1");
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
}
