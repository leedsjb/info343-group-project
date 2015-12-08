/**
 * An illustration of threads using the Runnable interface
 */

public class ThreadNameWithRunnable implements Runnable {
	private int sleepTime; // How long does the thread sleep in ms?

	// Use a thread t to execute the run method
	private Thread t;

	/**
	 * Creates a target for a thread given its name and its sleep time
	 * 
	 * @param name
	 *            the name of the thread
	 * @param n
	 *            the time the thread sleeps
	 */
	public ThreadNameWithRunnable(String name, int n) {
		// Give a name to the thread
		t = new Thread(this, name);

		// sleepTime
		sleepTime = n;

		// Start the thread
		t.start();
	}

	/**
	 * Prints the thread name several times. Stops for a while at every
	 * iteration.
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			// print the name of the thread
			System.out.println(t.getName() + " " + i);

			// The thread can be awakened while sleeping
			// use a try block to handle the possibility
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println(t.getName() + " is awake");
			}
		}
	}

	/**
	 * Creates 3 threads (2 + the main thread) and run them
	 * 
	 * @param args
	 *            the String array of the command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Create 2 threads
		ThreadNameWithRunnable p = new ThreadNameWithRunnable("One", 700);
		ThreadNameWithRunnable q = new ThreadNameWithRunnable("Two", 600);
		// Display also the thread that is used for main
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()
						+ " is awake");
			}
		}
	}
}
