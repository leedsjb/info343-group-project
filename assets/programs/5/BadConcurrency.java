/**
 * A class to illustrate the need of synchronization 2 threads change
 * independently an array of 2 integers
 */

public class BadConcurrency implements Runnable {
	private int[] data; // an array of 2 integers

	private Thread t; // thread to host our run method

	private int val;

	private int error; // number of errors

	private int count; // number of iterations

	/**
	 * Creates a target for a thread
	 * 
	 * @param name
	 *            the name of the thread
	 * @param n
	 *            the time the thread sleeps
	 * @param array
	 *            the array of data that the thread modifies
	 */
	public BadConcurrency(String name, int n, int[] array) {
		data = array;
		val = n;
		t = new Thread(this, name);
		t.start();
	}

	/**
	 * Modifies the data (in an infinite loop) and checks if it is consistent
	 */
	public void run() {
		// infinite loop
		while (true) {
			count++; // keep track of the number of iterations
			data[0] = val;
			data[1] = val;
			checkData();
		}
	}

	/**
	 * Checks the data
	 * 
	 */
	private void checkData() {
		if (data[0] != data[1]) {
			error++;
			System.out.println(t.getName() + ":  count=" + count + "  error="
					+ error);
		}
	}

	/**
	 * Starts two threads that modify concurrently an array of integers
	 * 
	 * @param args
	 *            the String array of the command line arguments (not used)
	 */
	public static void main(String[] args) {
		int[] myArray = new int[2];
		// create 2 threads and let them run indefinitely
		BadConcurrency p = new BadConcurrency("One", 1, myArray);
		BadConcurrency q = new BadConcurrency("Two", 2, myArray);
	}
}
