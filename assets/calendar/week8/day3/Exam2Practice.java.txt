import java.util.Stack;

public class Exam2Practice {

	private class ListNode {
		public int data;

		public ListNode next;

		public ListNode(int value) {
			data = value;
		}
	}

	private ListNode head;

	public static void main(String[] args) {
		int[] a = { 3, 7, 4, 9, 8, 12 };
		Exam2Practice ep = new Exam2Practice();
		ep.setLinkedList(a);
		System.out.println(ep);
		ep.switchPairs();
		System.out.println(ep);
		System.out.println();
		a = new int[] { 3, 7, 4, 9, 8, 12, 2 };
		ep.setLinkedList(a);
		System.out.println(ep);
		ep.switchPairs();
		System.out.println(ep);
		System.out.println();
		
		// to test the palindrome method
		System.out.println(ep.isAPalindrome("Was it a cat I saw?"));
		System.out.println(ep.isAPalindrome("No it wasn't a cat"));
	}

	public void setLinkedList(int[] a) {
		// first node
		if (a.length > 0) {
			head = new ListNode(a[0]);
			head.data = a[0];
		}
		// other nodes
		ListNode p = head;
		for (int i = 1; i < a.length; i++) {
			p.next = new ListNode(a[i]);
			p = p.next;
		}
	}

	// String representation of the list
	public String toString() {
		ListNode p = head;
		StringBuffer sb = new StringBuffer("[");
		if (p != null) {
			sb.append(p.data);
			p = p.next;
		}
		while (p != null) {
			sb.append(", " + p.data);
			p = p.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	// solution of the switch pairs problem from a UW exam
	public void switchPairs() {
		ListNode p = head;
		ListNode prev = null;
		ListNode prevprev = null;
		while (p != null) {
			prev = p;
			p = p.next;
			if (p != null) {
				// switch
				prev.next = p.next;
				p.next = prev;
				if (prevprev != null) {
					prevprev.next = p;
				} else {
					head = p;
				}
				// get ready for the next pair
				prevprev = prev;
				p = prev.next;
			}
		}

	}

	// Use a stack to check if a given string is a palindrome
	public boolean isAPalindrome(String s) {
		s = s.toLowerCase();
		StringBuffer sb1 = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				stack.push(s.charAt(i));
				sb1.append(c);
			}
		}
		System.out.println("\"" + sb1 + "\"");
		StringBuffer sb2 = new StringBuffer();
		while (!stack.isEmpty()) {
			sb2.append(stack.pop());
		}
		System.out.println("\"" + sb2 + "\"");
		// StringBuffer doesn't override equals 
		// convert to a string to use equals
		return sb1.toString().equals(sb2.toString());
	}

}
