import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;

/**
 * A simple Set implemented with a hash table
 * 
 * @author CSC 143
 */

public class MyHashSet<E> implements Set<E> {

	// Hash table
	private E[] table;

	// Indicates whether a location in the table has been used for storage or
	// not
	private boolean[] hasBeenUsed;

	// Default size of the table
	private static final int DEFAULT_CAPACITY = 9973; // a prime number

	// Number of elements in the set
	private int size;

	// Possible collision schemes
	public static final int LINEAR_PROBING = 1;

	public static final int QUADRATIC_PROBING = 2;

	// Selected collision scheme
	private int collisionScheme;

	/**
	 * Creates an empty set. The default scheme to resolve collisions is linear
	 * probing.
	 */
	public MyHashSet() {
		this.collisionScheme = MyHashSet.LINEAR_PROBING;
		this.table = (E[]) new Object[MyHashSet.DEFAULT_CAPACITY];
		this.hasBeenUsed = new boolean[MyHashSet.DEFAULT_CAPACITY];
	}

	/**
	 * Sets the collision scheme
	 * 
	 * @param collisionScheme
	 *            the collision scheme selected
	 * @throws IllegalArgumentException
	 *             if collisionScheme is not equal to LINEAR_PROBING and
	 *             QUADRATIC_PROBING
	 */
	public void setCollisionScheme(int collisionScheme) {
		if (collisionScheme != MyHashSet.LINEAR_PROBING
				&& collisionScheme != MyHashSet.QUADRATIC_PROBING) {
			throw new IllegalArgumentException("Invalid collision scheme");
		} else if (this.collisionScheme != collisionScheme) {
			this.collisionScheme = collisionScheme;
			this.changeSizeAndRehash(1);
		}
	}

	/**
	 * Gets the collision scheme for this set
	 * 
	 * @return the collision scheme for this set
	 */
	public int getCollisionScheme() {
		return this.collisionScheme;
	}

	/**
	 * Gets the size of this set
	 * 
	 * @return the size of this set
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Is this set empty?
	 * 
	 * @return true if the set is empty and false otherwise
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Is a given object in this set?
	 * 
	 * @param o
	 *            the object to find in this set
	 * @return true if the object is in the set, false otherswise
	 */
	public boolean contains(Object o) {
		if (o == null) {
			return false;
		}
		int index = this.getIndex(o);
		// Search until o is found, or a null not used yet is found in the table
		// or all of the elements in the table have been checked
		for (int i = 0; i < table.length; i++) {
			int indexToCheck = nextIndex(index, i);
			if (o.equals(table[indexToCheck])) {
				return true;
			} else if (table[indexToCheck] == null
					&& !hasBeenUsed[indexToCheck]) {
				return false;
			}
		}
		// all of the table was checked and o was not found
		return false;
	}

	/**
	 * Gets an iterator to iterate through this set
	 * 
	 * @return an iterator to iterate through this set
	 */
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	/**
	 * Add a given object to this set
	 * 
	 * @param o
	 *            the object to add to this set
	 * @return true if the object has been added, false otherwise
	 * @throws NullPointerException
	 *             if the object is null
	 */
	public boolean add(E o) {
		if (o == null) {
			throw new NullPointerException();
		}
		int index = this.getIndex(o);
		// Search until o is found, or a null is found in the table or
		// all of the elements in the table have been checked
		for (int i = 0; i < table.length; i++) {
			int indexToCheck = nextIndex(index, i);
			E item = this.table[indexToCheck];
			if (o.equals(item)) { // don't add: already in the table
				return false;
			} else if (item == null) {
				table[indexToCheck] = o;
				hasBeenUsed[indexToCheck] = true;
				this.size++;
				return true;
			}
		}

		// the item could not be added to the table (e.g. because the table is
		// full): increase the size of the table
		changeSizeAndRehash(2);
		return add(o);
	}

	/**
	 * Removes a given object from this set
	 * 
	 * @param o
	 *            the object to remove
	 * @return true if the object has been removed, or false otherwise
	 * @throws NullPointerException
	 *             if the object is null
	 */
	public boolean remove(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
		int index = this.getIndex(o);
		// Search until o is found, or a null is found at an unused location or
		// all of the elements in the table have been checked
		for (int i = 0; i < table.length; i++) {
			int indexToCheck = nextIndex(index, i);
			E item = this.table[indexToCheck];
			if (o.equals(item)) { // found it, remove it
				this.table[indexToCheck] = null;
				this.size--;
				return true;
			} else if (item == null && !hasBeenUsed[indexToCheck]) {
				// o is not in the table
				return false;
			}
		}

		// all of the table was checked, and o is not in it
		return false;
	}

	/**
	 * Gets a boolean array that describes the fill status of the hash table
	 * 
	 * @return an array of booleans that describes the fill status of the hash
	 *         table (a true value means that the hash table has an element at
	 *         the corresponding index, a false value means that there is no
	 *         element at the location)
	 */
	public boolean[] getHashFillStatus() {
		boolean[] status = new boolean[this.table.length];
		for (int i = 0; i < status.length; i++) {
			status[i] = (this.table[i] != null);
		}
		return status;
	}

	/**
	 * Clears this set
	 */
	public void clear() {
		this.table = (E[]) new Object[MyHashSet.DEFAULT_CAPACITY];
		this.hasBeenUsed = new boolean[MyHashSet.DEFAULT_CAPACITY];
		this.size = 0;
	}

	/**
	 * Gets a string describing this set
	 * 
	 * @return a string that describes this set
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<E> it = this.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	// private classes and methods
	// ---------------------------

	/**
	 * Gets the next position in the table in case of a collision in the table
	 * 
	 * @param index
	 *            the index where the collision happened
	 * @param count
	 *            the number of collisions so far for that given index
	 * @return the next index in the hash table
	 */
	private int nextIndex(int index, int count) {
		if (this.collisionScheme == MyHashSet.LINEAR_PROBING) {
			index = (index + count) % this.table.length;
		} else if (this.collisionScheme == MyHashSet.QUADRATIC_PROBING) {
			index = (index + count * count) % this.table.length;
		}
		return index;
	}

	/**
	 * Get the index in the hash table of the given object
	 * 
	 * @param o
	 *            the object whose index in the hash table is computed
	 * @throws NullPointerException
	 *             if o is null
	 */
	private int getIndex(Object o) {
		int index = Math.abs(o.hashCode()) % this.table.length;
		return index;
	}

	/**
	 * Increases the size of the table, and rehash the table
	 * 
	 * @param factor
	 *            the number that multiplies the length of the table (2 in
	 *            general, but might be 1 when the collision scheme changes)
	 */
	private void changeSizeAndRehash(int factor) {
		boolean success;
		do {
			success = true;
			E[] oldTable = table;
			boolean[] oldHasBeenUsed = hasBeenUsed;
			int oldSize = size;
			table = (E[]) new Object[getNextPrime(this.table.length * factor)];
			hasBeenUsed = new boolean[this.table.length];
			size = 0;
			for (int i = 0; i < oldTable.length; i++) {
				E o = oldTable[i];
				if (o != null) {
					success = false;
					int index = this.getIndex(o);
					// Search until o is found, or a null is found in the table
					// or all of the elements in the table have been checked
					for (int k = 0; k < table.length; k++) {
						int indexToCheck = nextIndex(index, k);
						E item = this.table[indexToCheck];
						if (item == null) {
							table[indexToCheck] = o;
							hasBeenUsed[indexToCheck] = true;
							this.size++;
							success = true;
							break;
						}
					}
					if (!success) {
						// not big enough
						table = oldTable;
						hasBeenUsed = oldHasBeenUsed;
						size = oldSize;
						factor++;
					}
				}
			}
		} while (!success);
	}

	/**
	 * Returns the smallest prime number greater than or equal to the given
	 * positive integer
	 * 
	 * @param n
	 *            the given integer
	 * @throws IllegalArgumentException
	 *             if n is not positive
	 */
	private int getNextPrime(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		while (!isPrime(n)) {
			n++;
		}
		return n;
	}

	/**
	 * Returns true if n is a prime number, or false otherwise
	 * 
	 * @param n
	 *            the positive integer to check
	 * @return true is n is a prime number, or false otherwise
	 * @throws IllegalArgumentException
	 *             is n is not positive
	 */
	private boolean isPrime(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		int m = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= m; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Inner class to define an iterator
	 */
	private class MyIterator implements Iterator<E> {
		private int index; // index of the next element in the table for

		// the iteration
		private int count; // number of elements returned by the iterator

		// so far
		private boolean canRemove; // true when next has been called, false

		// after a remove
		/**
		 * Creates a new iterator to iterate through the enclosing set instance
		 */
		public MyIterator() {
		}

		/**
		 * Any more elements in this iteration?
		 * 
		 * @return true if there are any elements left in the iteration, false
		 *         otherwise
		 */
		public boolean hasNext() {
			return this.count < MyHashSet.this.size;
		}

		/**
		 * Gets the next element in the iteration
		 * 
		 * @return the next element in the iteration
		 * @throws NoSuchElementException
		 *             if the there are no more elements in the iteration
		 */
		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}

			while (MyHashSet.this.table[this.index] == null) {
				this.index++;
			}
			E obj = MyHashSet.this.table[this.index];
			this.index++;
			this.count++;
			this.canRemove = true;

			return obj;
		}

		/**
		 * Remove the latest element visited by the iterator
		 * 
		 * @throws IllegalStateException
		 *             if next hasn't been called before calling remove, or if
		 *             remove has been called twice in a row.
		 */
		public void remove() {
			if (!this.canRemove) {
				throw new IllegalStateException();
			}

			// Remove the object at index - 1
			MyHashSet.this.table[this.index - 1] = null;
			MyHashSet.this.size--;
			this.count--;
			this.canRemove = false;
		}
	}

	// Unimplemented public methods
	// ----------------------------
	public Object[] toArray() {
		/** @todo Implement this java.util.Set method */
		throw new java.lang.UnsupportedOperationException(
				"Method toArray() not yet implemented.");
	}

	public Object[] toArray(Object[] a) {
		/** @todo Implement this java.util.Set method */
		throw new java.lang.UnsupportedOperationException(
				"Method toArray(Object[] a) not yet implemented.");
	}

	public boolean containsAll(Collection c) {
		/** @todo Implement this java.util.Set method */
		throw new java.lang.UnsupportedOperationException(
				"Method containsAll() not yet implemented.");
	}

	public boolean addAll(Collection c) {
		/** @todo Implement this java.util.Set method */
		throw new java.lang.UnsupportedOperationException(
				"Method addAll() not yet implemented.");
	}

	public boolean retainAll(Collection c) {
		/** @todo Implement this java.util.Set method */
		throw new java.lang.UnsupportedOperationException(
				"Method retainAll() not yet implemented.");
	}

	public boolean removeAll(Collection c) {
		/** @todo Implement this java.util.Set method */
		throw new java.lang.UnsupportedOperationException(
				"Method removeAll() not yet implemented.");
	}

	public boolean equals(Object o) {
		/** @todo Implement this java.util.Set method */
		throw new java.lang.UnsupportedOperationException(
				"Method equals() not yet implemented.");
	}

	/**
	 * Tests this class
	 */
	public static void main(String[] args) {
		MyHashSet<Integer> set = new MyHashSet<Integer>();
		System.out.println("set = " + set);

		for (int i = 0; i < 10; i++) {
			set.add(i * DEFAULT_CAPACITY);
		}
		System.out.println("set = " + set);

		System.out.println(DEFAULT_CAPACITY + " is in this set: "
				+ set.contains(new Integer(DEFAULT_CAPACITY)));
		System.out.println("5 is in this set: " + set.contains(new Integer(5)));

		set.remove(new Integer(15));
		System.out.println("After removing 15, set = " + set);
		set.remove(new Integer(DEFAULT_CAPACITY));
		System.out.println("After removing " + DEFAULT_CAPACITY + ", set = "
				+ set);

		// Change of collision scheme
		set.setCollisionScheme(MyHashSet.QUADRATIC_PROBING);
		System.out.println("set = " + set);

		// Test the iterator
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
			System.out.println("set = " + set);
		}

		for (int k = 2; k < 1000; k++) {
			if (set.isPrime(k)) {
				System.out.print(k + ", ");
			}
		}

	}
}
