public class RecursionExamples {
	public static void main(String[] args) {
		// palindrome
		String[] phrases = { "radar", "wasitacatisaw", "abc", "a", "" };
		for (String phrase : phrases) {
			System.out.println("\"" + phrase + "\""
					+ " is a palindrome (loop)? "
					+ isPalindromeWithLoop(phrase));
			System.out.println("\"" + phrase + "\""
					+ " is a palindrome (recursion)? "
					+ isPalindromeWithRecursion(phrase));
			System.out.println();
		}
		
		// towers of hanoi
		move(7, 1, 2, 3);
	}

	public static boolean isPalindromeWithLoop(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		return i >= j;
	}

	public static boolean isPalindromeWithRecursion(String s) {
		// s is a palindrome if
		// s is empty or of length 1 (= base case)
		// or if the first and last characters are the same and
		// the string without the first and last characters is also
		// a palindrome
		if (s.length() <= 1) { // base case
			return true;
		} else {
			return s.charAt(0) == s.charAt(s.length() - 1)
					&& isPalindromeWithRecursion(s.substring(1, s.length() - 1));
		}
	}

	// recursive solution to the towers of hanoi
	// moves nDisks disks from the left peg to the right peg
	public static void move(int nDisks, int left, int mid, int right) {
		// base case
		if (nDisks == 1) {
			System.out.println("Move 1 disk from peg = " + left + " to peg = "
					+ right);
		} else {
			move(nDisks - 1, left, right, mid);
			move(1, left, mid, right);
			move(nDisks - 1, mid, left, right);
		}
	}
}
