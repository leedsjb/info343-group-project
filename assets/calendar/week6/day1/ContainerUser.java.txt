import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ContainerUser {
	public static void main(String[] args) {
		Container c = new Container(25);
		System.out.println("count = " + countItems(c));
		// check that c has not been modified
		System.out.println("getCount = " + c.getCount());
	}

	@Test
	public void testCompare() {
		Random rand = new Random();

		for (int i = 1; i <= 10000; i++) {
			Container c1 = new Container(rand.nextInt(100));
			Container c2 = new Container(rand.nextInt(200));
			int count1 = c1.getCount();
			int count2 = c2.getCount();
			int cmp = compare(c1, c2);
			if (count1 < count2) {
				assertTrue(cmp == -1);
			} else if (count1 == count2) {
				assertTrue(cmp == 0);
			} else {
				assertTrue(cmp == +1);
			}
			assertTrue(c1.getCount() == count1);
			assertTrue(c2.getCount() == count2);
		}
	}

	/**
	 * Returns the count of the given Container object. -> uses recursion (No
	 * loops allowed) -> can't call getCount from Container -> must leave the
	 * Container object unchanged after it is called.
	 */
	public static int countItems(Container c) {
		if (c.isEmpty()) { // base case
			return 0;
		} else {
			c.removeOneItem();
			int count = 1 + countItems(c);
			c.addOneItem();
			return count;
		}
	}

	/**
	 * Write a method that takes two containers c1 and c2 and that returns -1 if
	 * the count of c1 is less that the count of c2 0 if the two counts are
	 * equal and +1 if the count of c1 is greater than the count of c2 Use
	 * recursion. After the call, c1 and c2 should have the same counts as they
	 * had initially You can't use countItems above
	 */
	public static int compare(Container c1, Container c2) {
		// c1 < c2 -> -1
		// c1 == c2 -> 0
		// c1 > c2 -> +1

		// base cases
		if (c1.isEmpty() && c2.isEmpty()) {
			return 0;
		} else if (c1.isEmpty()) {
			return -1;
		} else if (c2.isEmpty()) {
			return +1;
		} else { // recursion
			c1.removeOneItem();
			c2.removeOneItem();
			int cmp = compare(c1, c2);
			c2.addOneItem();
			c1.addOneItem();
			return cmp;
		}
	}

}
