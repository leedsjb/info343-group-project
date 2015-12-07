import java.util.Scanner;

public class BigO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Enter an integer (<=0 to quit): ");
			if (scan.hasNextInt()) {
				int n = scan.nextInt();
				scan.nextLine(); // grab the new line after the int
				if (n > 0) {
					testBigO(n);
				} else {
					scan.close();
					break;
				}
			} else {
				// not a number
				scan.nextLine();
			}
		} while (true);
	}

	public static void testBigO(int n) {

		// 1) a simple loop with n iterations
		long count = 0;
		for (long i = 1; i <= n; i++) {
			count++;
		}
		System.out.println("1) count = " + count + "\n");

		// 2) With a constant increment
		count = 0;
		for (long i = 1; i <= n; i += 10) {
			count++;
		}
		System.out.println("2) count = " + count + "\n");

		// 3) With an update *2
		count = 0;
		for (long i = 1; i <= n; i *= 2) {
			count++;
		}
		System.out.println("3) count = " + count + "\n");

		// 4) What if the update is *10
		for (long i = 1; i <= n; i *= 10) {
			count++;
		}
		System.out.println("4) count = " + count + "\n");

		// 5) Typical: two nested for loops with n iterations each
		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= n; j++) {
				count++;
			}
		}
		System.out.println("5) count = " + count + "\n");

		// 6) Two dependent nested for loops
		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= i; j++) {
				count++;
			}
		}
		System.out.println("6) count = " + count + "\n");

		// 7) This one is more difficult to analyze
		long k = 1;
		count = 0;
		while (k < n) {
			long j = k;
			while (j >= 1) {
				count++;
				j /= 2;
			}
			k++;
		}
		long exact = (long) (1 + n * (-1 + Math.log(n) / Math.log(2)));
		System.out.println("7) count = " + count + "\n");

		// 8) and with recursion
		long[] c = new long[1];
		doSomething(n, c);
		System.out.println("8) With recursion: count = " + c[0] + "\n");

		// 9) And a tricky one (it is not O(n log(n))
		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = i; j <= n; j *= 2) {
				count++;
			}
		}
		System.out.println("9) count = " + count + "\n");

		// 10) More standard
		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= n; j *= 2) {
				count++;
			}
		}
		System.out.println("10) count = " + count + "\n");

		// 11) what about this one?
		count = 0;
		long i = n;
		long j = 1;
		while (j < i) {
			i *= 2;
			j *= 3;
			count++;
		}
		System.out.println("11) count = " + count);
	}

	public static void doSomething(int n, long[] count) {
		if (n > 1) {
			count[0]++;
			doSomething(n / 2, count);
		}
	}

}
