import java.util.Arrays;

public class BigInt implements Comparable<BigInt> {

	// digits of the binary representation are stored in nodes
	private class Node {
		public int data;
		public Node next;
		public Node prev;

		public Node(int data) {
			if (data != 0 && data != 1) {
				throw new IllegalArgumentException("data = " + data);
			}
			this.data = data;
		}
	}

	// beginning and end of the doubly linked list
	private Node head, tail;
	// number of nodes in the linked list
	private int size;

	// BigInt(String val) Construct a BigInt object and initialize it with the
	// integer represented by the String. Throw an appropriate exception
	// (BigIntFormatException) if the string does not represent a signed integer
	// (i.e. contains illegal characters)
	public BigInt(String val) {
		val = val.trim();
		String[] parts = val.split("\\s+");
		System.out.println("val = " + val + ", parts = "
				+ Arrays.toString(parts));
		// a valid number comes in 1 or 2 pieces
		if (parts.length == 0 || parts.length > 2 || parts[0].length() == 0) {
			throw new BigIntFormatException();
		}
		// if 2 pieces, the first piece must be + or -
		if (parts.length == 2 && !parts[0].equals("-") && !parts[0].equals("+")) {
			throw new BigIntFormatException();
		}

		String number = parts[0] + ((parts.length > 1) ? parts[1] : "");
		int sign = +1;
		if (number.charAt(0) == '-') {
			sign = -1;
		}
		if (number.charAt(0) == '+' || number.charAt(0) == '-') {
			number = number.substring(1); // drop the sign
		}

		// only digits in number?
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			// if (!(c >= '0' && c <= '9')) {
			if (!Character.isDigit(c)) {
				throw new BigIntFormatException();
			}
		}

		// construct the linked list
		while (!number.equals("0")) {
			int d = mod2(number);
			Node n = new Node(d);
			if (tail == null) {
				tail = n;
				head = n;
			} else {
				n.next = head;
				head.prev = n;
				head = n;
			}
			size++;
			number = divideBy2(number);
		}
		// add a 0 for the sign (we will take the 2's complement
		// later if negative)
		Node n = new Node(0);
		n.next = head;
		if (head != null) {
			head.prev = n;
		} else {
			tail = n;
		}
		head = n;
		size++;

		if (sign == -1) {
			// 1's complement
			Node p = head;
			while (p != null) {
				p.data = 1 - p.data;
				p = p.next;
			}
			// 2's complement: just add 1
			int carry = 1;
			p = tail;
			while (p != null) {
				p.data += carry;
				carry = p.data / 2;
				p.data %= 2;
				p = p.prev;
			}
		}

		// remove any leading 0's and 1's (except the last 0 or 1)
		removeLeading0sor1s();
	}

	// BigInt(BigInt val) This is the copy constructor. It should make a deep
	// copy of val. Making a deep copy is not strictly necessary since as
	// designed a BigInt is immutable, but it is good practice.
	public BigInt(BigInt val) {

	}

	// BigInt(long val)
	// Construct a BigInt object and intitialize it wth the value stored in val
	public BigInt(long val) {
		this(val + "");
	}

	// BigInt add(BigInt val) Returns a BigInt whose value is (this + val)
	public BigInt add(BigInt val) {
		return null;
	}

	// BigInt multiply(BigInt val)
	// Returns a BigInt whose value is (this * val)
	public BigInt multiply(BigInt val) {
		return null;
	}

	// BigInt subtract(BigInt val) Returns a BigInt whose value is (this - val)
	public BigInt subtract(BigInt val) {
		return null;
	}

	// BigInt factorial() Returns a BigInt whose value is this!
	public BigInt factorial() {
		return null;
	}

	// int compareTo(BigInt) Have the BigInt class implement the Comparable
	// interface.
	public int compareTo(BigInt b) {
		return 0;
	}

	// boolean equals(Object)
	// Override the equals() method from Object.
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj instanceof BigInt) {
			BigInt b = (BigInt) obj;
			if (size != b.size) {
				return false;
			}
			Node p = head;
			Node q = b.head;
			while (p != null) {
				if (p.data != q.data) {
					return false;
				}
				p = p.next;
				q = q.next;
			}
			return true;
		} else {
			return false;
		}
	}

	// String toString() Returns the decimal representation of this BigInt as a
	// String
	public String toString() {
		return null;
	}

	// String toString2s() Returns the 2's complement representation of this
	// BigInt as a String using the minimum number of digits necessary (e.g. 0
	// is "0", -1 is "1", 2 is "010", -2 is "10", etc).
	public String toString2s() {
		String s = head.data + "";
		Node p = head.next;
		while (p != null) {
			s += p.data;
			p = p.next;
		}
		return s;
	}

	// divides by 2
	private String divideBy2(String s) {
		String q = "";
		int carry = 0;
		for (int i = 0; i < s.length(); i++) {
			int d = s.charAt(i) - '0';
			q += (d + 10 * carry) / 2;
			carry = d % 2;
		}

		// remove any leading 0's (except if q is "0")
		if (q.charAt(0) == '0' && q.length() > 1) {
			int i = 1;
			while (i < q.length() && q.charAt(i) == '0') {
				i++;
			}
			q = q.substring(i);
			if (q.length() == 0) {
				q = "0";
			}
		}

		return q;
	}

	// mods 2
	private int mod2(String s) {
		int d = s.charAt(s.length() - 1) - '0';
		return d % 2;
	}

	private void removeLeading0sor1s() {
		int data = head.data;
		Node p = head.next;
		while (p != null && p.data == data) {
			head = p;
			head.prev = null;
			size--;
			p = p.next;
		}
	}

}
