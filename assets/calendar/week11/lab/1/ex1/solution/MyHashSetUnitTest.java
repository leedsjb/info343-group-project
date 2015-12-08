import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import junit.framework.TestCase;

public class MyHashSetUnitTest extends TestCase {

	/**
	 * Tests the common methods of a SimpleHashSet
	 */
	public void testSimpleHashSet() {
		Set<String> s;

		s = new MyHashSet<String>();
		assertTrue(s.size() == 0);
		assertTrue(s.isEmpty());
		String[] elems = { "Red", "Green", "Blue" };
		for (int i = 0; i < 3; i++) {
			assertTrue(s.add(elems[i]));
			assertTrue(s.size() == i + 1);
			assertTrue(s.contains(elems[i]));
		}
		assertFalse(s.isEmpty());
		for (int i = 0; i < 3; i++) {
			assertTrue(s.remove(elems[i]));
			assertFalse(s.remove(elems[i]));
		}
		assertTrue(s.size() == 0);
		assertTrue(s.isEmpty());
	}

	/**
	 * Tests rehashing of a MyHashSet
	 */
	public void testRehash() {
		Set<Integer> s = new MyHashSet<Integer>();
		// put many entries
		final int SIZE = 100000;
		for (int i = 0; i < SIZE; i++) {
			s.add(i);
		}
		assertTrue(s.size() == SIZE);
		for (int i = 0; i < SIZE; i++) {
			assertTrue(s.contains(i));
		}
		assertTrue(s.remove(5000));
		assertFalse(s.remove(5000));
		assertTrue(s.size() == SIZE - 1);
	}

	/**
	 * Tests the iterator
	 */
	public void testIterator() {

		Set<Integer> s = new MyHashSet<Integer>();
		final int SIZE = 300;
		for (int i = 0; i < SIZE; i++) {
			s.add(i);
		}
		assertTrue(s.size() == SIZE);
		for (int i = 0; i < SIZE; i++) {
			assertTrue(s.contains(i));
		}

		// Simple iteration
		int count = 0;
		for (Integer i : s) {
			assertTrue(s.contains(i));
			count++;
		}
		assertTrue(count == SIZE);

		assertTrue(s.remove(100));
		assertTrue(s.size() == SIZE - 1);
		assertFalse(s.contains(100));
		assertFalse(s.remove(100));
		assertTrue(s.remove(99));
		assertTrue(s.size() == SIZE - 2);
		assertFalse(s.contains(99));
		assertTrue(s.add(99));
		assertTrue(s.contains(99));

		// and with the iterator
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			assertTrue(s.contains(i));
			it.remove();
			assertFalse(s.contains(i));
			try {
				it.remove();
				assertTrue(false);
			} catch (IllegalStateException e) {
			}
		}
		assertTrue(s.isEmpty());
		try {
			it.next();
			assertTrue(false);
		} catch (NoSuchElementException e) {
		}
	}

}
