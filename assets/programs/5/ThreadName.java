/**
 * A simple illustration of threads
 */

public class ThreadName extends Thread {
	private int sleepTime; // How long does the thread sleep in ms

	/**
	 * Creates a thread given its name and sleep time
	 * 
	 * @param name
	 *            the name of the thread
	 * @param n
	 *            the time it sleeps in milliseconds
	 */
	public ThreadName(String name, int n) {
		// Give a name to the thread
		super(name);
		// sleepTime
		sleepTime = n;
	}

	/**
	 * Prints the name of the thread in a loop. Pauses the thread at every
	 * iteration.
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			// print the name of the thread
			System.out.println(getName() + " " + i);

			// The thread can be awakened while sleeping
			// use a try block to handle the possibility
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println(getName() + " is awake");
			}
		}
	}

	/**
	 * Creates 3 threads (2 threads + the main thread) and run them
	 * 
	 * @param args
	 *            the String array of the command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Create 2 threads
		ThreadName p = new ThreadName("One", 700);
		p.start();
		ThreadName q = new ThreadName("Two", 600);
		q.start();
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
