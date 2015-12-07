import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Integer[] a = { 1, 5, 7, 11, 15, 19 };
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Enter an integer (or q to quit): ");
			String input = scan.nextLine().trim().toLowerCase();
			if (input.startsWith("q")) {
				break;
			} else {
				try {
					Integer key = Integer.parseInt(input);
					System.out.println("Binary search index = "
							+ binarySearch(0, a.length - 1, key, a));
				} catch (NumberFormatException e) {
					System.out.println("Bad input!");
				}
			}
		} while (true);
	}

	// Search for key in a between a[low] and a[high]
	// precondition: a is sorted
	// return the index of the key if it is in a
	// or -index - 1 if not in a where index is where the key
	// would be inserted in a.
	/**
	 * Given a value, returns the value of the index where the value appears in
	 * the array, or -1 if the value is not in the array
	 * 
	 * @param <E>
	 * 
	 * @param val
	 *            the value to find
	 * @param first
	 *            the index of the leftmost element in the range to search
	 * @param last
	 *            the index of the rightmost element in the range to search
	 */
	public static <E extends Comparable<E>> int binarySearch(int first,
			int last, E value, E[] a) {
		// base case ?
		if (first > last) {
			return -1 - first;
		} else {
			int mid = (first + last) / 2;
			if (value.compareTo(a[mid]) < 0) {
				// the value may be in [first, mid - 1]
				last = mid - 1;
			} else if (value.compareTo(a[mid]) > 0) {
				// the value may be in [mid + 1, last]
				first = mid + 1;
			} else { // found!
				return mid;
			}
			return binarySearch(first, last, value, a);
		}
	}
}
