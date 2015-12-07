import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("Enter an integer (or q to quit): ");
			String line = scan.nextLine();
			if (line.trim().toLowerCase().startsWith("q")) {
				break;
			} else {
				try {
					int n = Integer.parseInt(line);
					System.out.println(n + " in binary = " + toBinary(n));
				} catch (NumberFormatException e) {
					System.out.println("Invalid input");
				}
			}
		}
	}

	/**
	 * Returns the binary representation of a given integer
	 */
	public static String toBinary(int n) {
		String s = "";
		boolean negative = (n < 0);
		n = Math.abs(n);
		// binary rep of +abs(n)
		while (n > 0) {
			int d = n % 2;
			n /= 2;
			s = d + s;
		}
		s = "0" + s;
		if (negative) {
			// 1's complement
			String s1 = "";
			for (int i = 0; i < s.length(); i++) {
				int d = (s.charAt(i) - '0');
				s1 += (1 - d);
				// s1 += ('1' - s.charAt(i)); would work as well
			}
			// 2's complement: add 1
			String s2 = "";
			int carry = 1;
			for (int i = s1.length() - 1; i >= 0; i--) {
				int d = (s1.charAt(i) - '0');
				d += carry;
				carry = d / 2;
				d %= 2;
				s2 = d + s2;
			}
			// remove the leading 1's except the first one
			int i = 0;
			while (i < s2.length() - 1 && s2.charAt(i + 1) == '1') {
				i++;
			}
			return s2.substring(i);
		} else {
			return s;
		}
	}

}
