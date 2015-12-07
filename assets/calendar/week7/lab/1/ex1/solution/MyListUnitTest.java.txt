import java.util.Iterator;
import java.util.NoSuchElementException;
import junit.framework.TestCase;

public class MyListUnitTest extends TestCase {

	public void testMyArrayList() {
		// Create a List
		MyList<Integer> l = new MyArrayList<Integer>();
		assertTrue(l.size() == 0);

		// Add 9 integers
		for (int i = 1; i <= 9; i++) {
			assertFalse(l.contains(i));
			l.add(i);
			assertTrue(l.contains(i));
			assertTrue(l.get(i - 1) == i);
			assertTrue(l.indexOf(new Integer(i)) == i - 1);
		}
		assertTrue(l.size() == 9);
		assertTrue(l.indexOf(new Integer(34)) == -1);

		// Make a copy of l
		MyList<Integer> copy = new MyArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			copy.add(i);
		}
		assertTrue(l.equals(copy));
		assertTrue(copy.remove(4)); // remove element at index 4
		assertFalse(copy.contains(5));
		assertTrue(copy.size() == 8);
		assertTrue(copy.add(18));
		assertTrue(copy.contains(18));
		assertTrue(copy.size() == 9);
		assertFalse(copy.equals(l));

		// Clear the list
		l.clear();
		assertTrue(l.size() == 0);
		assertTrue(l.isEmpty());

		// Add some integers to the list and null
		for (int i = 1; i <= 3; i++) {
			assertTrue(l.add(new Integer(i)));
		}
		assertTrue(l.add(1, null));
		assertTrue(l.indexOf(null) == 1);
		assertTrue(l.indexOf(new Integer(1)) == 0);

		// Remove the front element
		int count = l.size();
		while (!l.isEmpty()) {
			count--;
			assertTrue(l.remove(0));
			assertTrue(l.size() == count);
		}
		assertTrue(l.isEmpty());

		// Create a new list
		for (int i = 0; i <= 10; i++) {
			assertTrue(l.add(l.size(), new Integer(i)));
		}
		int value = 0;
		for (Integer i : l) {
			assertTrue(i == value);
			value++;
		}

		// Remove the last element
		assertTrue(l.remove(l.size() - 1));
		for (int i = 0; i < l.size(); i++) {
			assertTrue(l.get(i) == i);
		}

		// Add another element
		assertTrue(l.add(new Integer(100)));
		assertTrue(l.indexOf(new Integer(100)) == l.size() - 1);
		assertTrue(l.get(l.size() - 1) == 100);

		// clear the list with an iterator
		Iterator<Integer> it = l.iterator();
		count = l.size();
		int[] val = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 100 };
		int index = 0;
		while (it.hasNext()) {
			assertTrue(it.next() == val[index++]);
			it.remove();
			count--;
			assertTrue(l.size() == count);
		}
		assertTrue(l.isEmpty());
		try {
			it.next();
			assertFalse(true);
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			assertFalse(true);
		}

		try {
			it.remove();
			assertFalse(true);
		} catch (IllegalStateException e) {
		} catch (Exception e) {
			assertFalse(true);
		}
	}

	public void testMyLinkedList() {
		// Create a List
		MyList<Integer> l = new MyLinkedList<Integer>();
		assertTrue(l.size() == 0);

		// Add 9 integers
		for (int i = 1; i <= 9; i++) {
			assertFalse(l.contains(i));
			l.add(i);
			assertTrue(l.contains(i));
			assertTrue(l.get(i - 1) == i);
			assertTrue(l.indexOf(new Integer(i)) == i - 1);
		}
		assertTrue(l.size() == 9);
		assertTrue(l.indexOf(new Integer(34)) == -1);

		// Make a copy of l
		MyList<Integer> copy = new MyLinkedList<Integer>();
		for (int i = 1; i <= 9; i++) {
			copy.add(i);
		}
		assertTrue(l.equals(copy));
		assertTrue(copy.remove(4)); // remove element at index 4
		assertFalse(copy.contains(5));
		assertTrue(copy.size() == 8);
		assertTrue(copy.add(18));
		assertTrue(copy.contains(18));
		assertTrue(copy.size() == 9);
		assertFalse(copy.equals(l));

		// Clear the list
		l.clear();
		assertTrue(l.size() == 0);
		assertTrue(l.isEmpty());

		// Add some integers to the list and null
		for (int i = 1; i <= 3; i++) {
			assertTrue(l.add(new Integer(i)));
		}
		assertTrue(l.add(1, null));
		assertTrue(l.indexOf(null) == 1);
		assertTrue(l.indexOf(new Integer(1)) == 0);

		// Remove the front element
		int count = l.size();
		while (!l.isEmpty()) {
			count--;
			assertTrue(l.remove(0));
			assertTrue(l.size() == count);
		}
		assertTrue(l.isEmpty());

		// Create a new list
		for (int i = 0; i <= 10; i++) {
			assertTrue(l.add(l.size(), new Integer(i)));
		}
		int value = 0;
		for (Integer i : l) {
			assertTrue(i == value);
			value++;
		}

		// Remove the last element
		assertTrue(l.remove(l.size() - 1));
		for (int i = 0; i < l.size(); i++) {
			assertTrue(l.get(i) == i);
		}

		// Add another element
		assertTrue(l.add(new Integer(100)));
		assertTrue(l.indexOf(new Integer(100)) == l.size() - 1);
		assertTrue(l.get(l.size() - 1) == 100);

		// clear the list with an iterator
		Iterator<Integer> it = l.iterator();
		count = l.size();
		int[] val = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 100 };
		int index = 0;
		while (it.hasNext()) {
			assertTrue(it.next() == val[index++]);
			it.remove();
			count--;
			assertTrue(l.size() == count);
		}
		assertTrue(l.isEmpty());
		try {
			it.next();
			assertFalse(true);
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			assertFalse(true);
		}

		try {
			it.remove();
			assertFalse(true);
		} catch (IllegalStateException e) {
		} catch (Exception e) {
			assertFalse(true);
		}
	}
}
