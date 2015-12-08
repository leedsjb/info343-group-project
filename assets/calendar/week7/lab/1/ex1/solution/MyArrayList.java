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
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Negative initial capacity="
					+ initialCapacity);

		this.items = (E[]) new Object[initialCapacity];
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
		return this.size;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Appends the specified element to the end of this list
	 */
	public boolean add(E o) {
		// If there is no room in the array items
		// Make room for the new element
		if (this.size == this.items.length) {
			E[] temp = (E[]) new Object[2 * this.items.length];
			System.arraycopy(this.items, 0, temp, 0, size);
			this.items = temp;
		}

		this.items[size++] = o;
		return true;
	}

	/**
	 * Empties this List
	 */
	public void clear() {
		// many ways of doing it: e.g.
		this.items = (E[]) new Object[DEFAULT_CAPACITY];
		// Could also null all of the elements of items
		size = 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public E get(int index) {
		if (index < 0 || index >= this.size)
			throw new java.lang.IndexOutOfBoundsException("Index=" + index);
		return (E) this.items[index]; // generates a warning!
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 */
	public int indexOf(Object o) {
		// If o is null
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (this.items[i] == null)
					return i;
		} else // o is an object
		{
			for (int i = 0; i < size; i++)
				if (this.items[i].equals(o))
					return i;
		}

		// o is not in the list
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(Object o) {
		return this.indexOf(o) >= 0;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException("Index=" + index);

		// compact the array
		for (int i = index + 1; i < size; i++)
			this.items[i - 1] = this.items[i];
		size--;

		// let's gc do its work
		this.items[size] = null;

		return true;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(Object o) {
		int index = this.indexOf(o);
		if (index == -1)
			return false;
		else
			return this.remove(index);
	}

	/**
	 * Adds the specified object at the specified location
	 */
	public boolean add(int index, E o) {
		if (index < 0 || index > this.size)
			throw new IndexOutOfBoundsException("Index=" + index);

		// one way: add at the end and then shift the elements around
		this.add(o);
		for (int i = size - 1; i > index; i--)
			this.items[i] = this.items[i - 1];
		this.items[index] = o;

		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 */
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			// o is an ArrayList
			MyArrayList otherList = (MyArrayList) o;
			// if the number of elements is not the same, this and o are not the
			// same
			if (otherList.size != this.size)
				return false;
			// Check the elements one by one
			for (int i = 0; i < this.size; i++)
				if (!this.items[i].equals(otherList.items[i]))
					return false;
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

		private MyArrayList<E> list;

		private int lastIndex = -1; // index of the object most recently by next

		/**
		 * Create an iterator for a MyArrayList
		 */
		public MyIterator(MyArrayList<E> list) {
			this.list = list;
		}

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			return index < this.list.size;
		}

		/**
		 * Return the current element in the list and move to the next element
		 */
		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();
			this.lastIndex = index;
			return (E) this.list.items[index++]; // Warning!
		}

		/**
		 * Remove the last object returned by next
		 */
		public void remove() {
			if (this.lastIndex == -1)
				throw new IllegalStateException();
			this.list.remove(lastIndex);
			this.index--;
			this.lastIndex = -1;
		}
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public Iterator<E> iterator() {
		return new MyIterator(this);
	}
}
