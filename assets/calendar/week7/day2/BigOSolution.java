import java.util.Scanner;

public class BigOSolution {

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

		// 1) O(n): a simple loop with n iterations
		long count = 0;
		for (long i = 1; i <= n; i++) {
			count++;
		}
		System.out.println("1) O(n): count = " + count + "\n");

		// 2) O(n): the increment for i is irrelevant as long
		// as it is a constant
		count = 0;
		for (long i = 1; i <= n; i += 10) {
			count++;
		}
		System.out.println("2) O(n): count = " + count + "\n");

		// 3) O(log n): since i=1,2,4,...,2^p where p = log(n)
		count = 0;
		for (long i = 1; i <= n; i *= 2) {
			count++;
		}
		System.out.println("3) O(log n): count = " + count + "\n");

		// 4) O(log n): the multiplier for i is irrelevant (as long as it is
		// greater than 1!)
		for (long i = 1; i <= n; i *= 10) {
			count++;
		}
		System.out.println("4) O(log n): count = " + count + "\n");

		// 5) O(n^2); typical two nested for loops with n iterations each
		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= n; j++) {
				count++;
			}
		}
		System.out.println("5) O(n^2): count = " + count + "\n");

		// 6) O(n^2): 1 + 2 + 3 + ... + n = n(n+1)/2 = O(n^2)
		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= i; j++) {
				count++;
			}
		}
		System.out.println("6) O(n^2): count = " + count + "\n");

		// 7) O(n log n):
		// the number of iterations is 1 + 2 + 2 + 3 + 3 + 3 + 3 + ...
		// = 1 + 2*2 + 3*4 + 4*8 + 5*16 + ...
		// = sum(i*2^(i-1)) = 1/2 sum(i*2^i)
		// = 1 + 2^p(p-1) if n = 2^p
		// To see the last step, compute first sum(2^(i*x), i=1 to p)
		// = ( 2^((p + 1)* x) - 2^x)/(2^x - 1)
		// Then take the derivative with respect to x ->
		// sum(i*ln(2)*2^(i*x), i=1 to p)
		// = d/dx ( ( 2^((p + 1)* x) - 2^x)/(2^x - 1) )
		// = (2^x (1 + 2^(p x) (-1 + (-1 + 2^x) p)) ln(2) /(-1 + 2^x)^2
		// It follows that
		// sum(i*2^(i-1), i=1 to p) = 1/2 sum(i*2^i, i=1 to p)
		// = 1/(2 ln 2) ((2^x (1 + 2^(p x) (-1 + (-1 + 2^x) p)) ln(2) /(-1 +
		// 2^x)^2)) for x = 1
		// = 1 + 2^p (-1 + p) which is O(n log n)
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
		System.out.println("7) O(n log(n)): count = " + count
				+ ", computed (same if n is a power of 2) = " + exact + "\n");

		// 8) and with recursion
		long[] c = new long[1];
		doOLogn(n, c);
		System.out
				.println("8) O(log n) with recursion: count = " + c[0] + "\n");

		// 9) And a tricky one: it looks like O(n log(n)) but it is actually
		// O(n)
		// The number of iterations of the inner loop is = p + 1
		// such that i*2^p = n, that is p = log(n/i)
		// The total number of iterations is sum(log(n/i) + 1, i=1 to n)
		// total =
		// = sum(1 + log(n) - log(i))
		// = n + n log(n) - sum(log(i), i=1 to n)
		// = n + n log(n) - log(1*2...*n)
		// = n + n log(n) - log(n!)
		// For n large, we can use Stirling's formula: n! = n^n * exp(-n) *
		// sqrt(2*pi*n)
		// So log(n!) = n log(n) - n
		// And total = n + n log(n) - n log(n) + n = 2n = O(n)
		// You can check below that count is always about 2*n

		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = i; j <= n; j *= 2) {
				count++;
			}
		}
		System.out.println("9) O(n): count = " + count + "\n");

		// 10) The following is of course O(n log(n))
		count = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= n; j *= 2) {
				count++;
			}
		}
		System.out.println("10) O(n log(n)): count = " + count + "\n");

		// 11) what about this one?
		// after p iterations: i = 2^p * n and j = 3^p
		// stops if 2^p * n = 3^p that is 1.5^p = n or p = ln(n)/ln(1.5) =
		// O(log(n))
		count = 0;
		long i = n;
		long j = 1;
		while (j < i) {
			i *= 2;
			j *= 3;
			count++;
		}
		System.out.println("11) O(log(n)): count = " + count);
	}

	public static void doOLogn(int n, long[] count) {
		if (n > 1) {
			count[0]++;
			doOLogn(n / 2, count);
		}
	}

}
