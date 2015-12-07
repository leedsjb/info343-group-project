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

	// Has this location been used in the table?
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
		int index = this.getIndex(o);
		boolean found = false;
		int count = 0;
		// Search until o is found, or a null is found in the table or
		// all of the elements in the table have been checked

		return found;
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
		int index = this.getIndex(o);
		boolean found = false;
		int count = 0;
		// Search until o is found, or a null is found in the table or
		// all of the elements in the table have been checked
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
		int index = this.getIndex(o);
		boolean found = false;
		int count = 0;
		// Search until o is found, or a null is found in the table or
		// all of the elements in the table have been checked
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
	}

	/**
	 * Clears this set
	 */
	public void clear() {
		this.table = new Object[MyHashSet.DEFAULT_CAPACITY];
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
		// Be careful with any negative index
	}

	/**
	 * Increases the size of the table, and rehash the table
	 * 
	 * @param factor
	 *            the number that multiplies the length of the table (2 in
	 *            general, but might be 1 when the collision scheme changes)
	 */
	private void changeSizeAndRehash(int factor) {

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
		 * @throws java.util.NoSuchElementException
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
}
