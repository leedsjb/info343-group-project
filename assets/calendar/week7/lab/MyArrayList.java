import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of MyList with an array (a longer exercise would be to
 * implement the List interface as is done in the class java.util.ArrayList: the
 * source of the ArrayList class is available from Sun. Check it out).
 */

public class MyArrayList<E> implements MyList<E> {

	// Use an array for the implementation
	private E[] items;

	// Default capacity of the array
	private static final int DEFAULT_CAPACITY = 10;

	// Number of elements in the array
	private int size;

	/**
	 * Constructs a MyArrayList with a specified capacity
	 */
	public MyArrayList(int initialCapacity) {
		items = (E[]) new Object[initialCapacity];
	}

	/**
	 * Constructs a MyArrayList with a default capacity
	 */
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Appends the specified element to the end of this list
	 */
	public boolean add(E o) {
		// If there is no room in the array items
		// Make room for the new element
		if (size == items.length) {
			// increase the current length of the array by DEFAULT_CAPACITY
			E[] temp = (E[]) new Object[items.length + DEFAULT_CAPACITY];
			// copy items in temp
			System.arraycopy(items, 0, temp, 0, items.length);
			// could also use copyOf in Arrays
			items = temp;
		}
		// add the new element
		items[size] = o;
		size++;
		return true;
	}

	/**
	 * Empties this List
	 */
	public void clear() {
		size = 0;
		// not needed though a good idea to free the memory used by the array
		items = (E[]) new Object[DEFAULT_CAPACITY];
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		}
		return items[index];
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 */
	public int indexOf(Object o) {
		// If o is null (look for a null element in the array)
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (items[i] == null) {
					return i;
				}
			}
		} else // o is an object (use equals)
		{
			for (int i = 0; i < size; i++) {
				if (o.equals(items[i])) {
					return i;
				}
			}
		}

		// If we get here, o is not in the list
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(Object o) {
		// easy with indexOf
		return indexOf(o) != -1;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		}
		// compact the array
		for (int i = index + 1; i < size; i++) {
			items[i - 1] = items[i];
		}
		items[size - 1] = null; // garbage collect if it is the last that is
								// removed
		size--;
		return true;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(Object o) {
		// easy with indexOf and remove
		int index = indexOf(o);
		if (index != -1) {
			return remove(index);
		} else {
			return false;
		}
	}

	/**
	 * Adds the specified object at the specified location
	 */
	public boolean add(int index, E o) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		}
		// one way: add at the end and then shift
		// the elements around
		add(o); // may make the array bigger
		// size has been incremented by 1
		for (int i = size - 2; i >= index; i--) {
			items[i + 1] = items[i];
		}
		items[index] = o;
		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 */
	public boolean equals(Object o) {
		if (o instanceof MyArrayList) {
			// o is an ArrayList
			MyArrayList<E> list = (MyArrayList<E>) o;
			// if the number of elements is not the same, this and o are not the
			// same
			if (list.size != this.size) {
				return false;
			}
			// Check the elements one by one
			for (int i = 0; i < size; i++) {
				if (list.items[i] == null && this.items[i] != null) {
					return false;
				} else if (!list.items[i].equals(this.items[i])) {
					return false;
				}
			}
			// At this point, the lists are equal
			return true;
		} else {
			return false;
		}
	}

	/**
	 * An inner class to define the iterator
	 */
	private class MyIterator implements Iterator<E> {
		private int index = 0;

		private int lastIndex = -1; // index of the object most recently visited
		// by next

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			// this refers to the current instance of
			// MyIterator
			// MyArrayList.this refers to the current
			// encompassing instance of MyArrayList
			return index < MyArrayList.this.size;
			// could also be written
			// return index < size;
			// since there is no size field
			// in the MyIterator class
		}

		/**
		 * Returns the current element in the list and move to the next element
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// E elt = items[index];
			// index ++;
			// return elt;
			lastIndex = index;
			return items[index++];
		}

		/**
		 * Removes the last object returned by next
		 */
		public void remove() {
			if (lastIndex == -1) {
				throw new IllegalStateException();
			}
			MyArrayList.this.remove(lastIndex);
			lastIndex = -1;
			index--;
		}
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public Iterator<E> iterator() {
		return new MyIterator();
	}
}
