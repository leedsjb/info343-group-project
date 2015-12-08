import java.util.Stack;

public class Language {

	public static void main(String[] args) {
		String[] sYes = { "a$a", "$", "abc$cba" };
		String[] sNo = { "Ab$Ab", "xw$WX", "abc$cb", "" };
		System.out.println("sYes (contains)");
		for (String st : sYes) {
			System.out.println(contains(st));
		}
		System.out.println();
		System.out.println("sNo (contains)");
		for (String st : sNo) {
			System.out.println(contains(st));
		}
		System.out.println();
		System.out.println("sYes (containsRec)");
		for (String st : sYes) {
			System.out.println(contains(st));
		}
		System.out.println();
		System.out.println("sNo (containsRec)");
		for (String st : sNo) {
			System.out.println(contains(st));
		}

	}

	public static boolean contains(String s) {
		Stack<Character> st = new Stack<Character>();
		boolean foundDollar = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '$') {
				foundDollar = true;
				continue;
			}
			if (!foundDollar) {
				st.push(s.charAt(i));
			} else {
				if (!st.isEmpty()) {
					if (c != st.pop()) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return foundDollar && st.isEmpty();
	}

	public boolean containsRec(String s) {
		if (s.length() <= 1) {
			return s.equals("$");
		} else {
			char c1 = s.charAt(0);
			char c2 = s.charAt(s.length() - 1);
			return c1 == c2 && containsRec(s.substring(1, s.length() - 1));
		}
	}

}
