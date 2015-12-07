import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of MyList with a linked list (a longer exercise would be to
 * implement the List interface as is done in the class java.util.LinkedList:
 * the source of the LinkedList class is available from Sun. Check it out).
 */

public class MyLinkedList<E> implements MyList<E> {

	// A private class to represent a Node in the linked list
	private class Node {
		public E item;

		public Node next;

		// a convenient constructor
		public Node(E o) {
			this.item = o;
			this.next = null;
		}
	}

	// The start of the linked list
	private Node head;

	// The last Node in the linked list
	private Node tail;

	// Number of elements in the list
	private int size;

	/**
	 * Creates an empty list (this constructor is not necessary)
	 */
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
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
		// If this is the first element in the list
		if (head == null) {
			head = new Node(o);
			tail = head;
		} else {
			tail.next = new Node(o);
			tail = tail.next;
		}

		size++;
		return true;
	}

	/**
	 * Empties this List
	 */
	public void clear() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public E get(int index) {
		if (index < 0 || index >= this.size)
			throw new java.lang.IndexOutOfBoundsException("Index=" + index);

		// Find it
		int position = 0;
		Node p = head;
		while (p.next != null && position != index) {
			p = p.next;
			position++;
		}

		return p.item;
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 */
	public int indexOf(Object o) {
		int position = 0;
		Node p = head;

		// If o is null
		if (o == null) {
			while (p != null) {
				if (p.item == null)
					return position;
				else {
					p = p.next;
					position++;
				}
			}
		} else // o is an object
		{
			while (p != null) {
				if (p.item.equals(o))
					return position;
				else {
					position++;
					p = p.next;
				}
			}
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

		// Find the corresponding node
		Node p = head;
		Node prev = null;
		int position = 0;

		while (p != null && position != index) {
			prev = p;
			p = p.next;
			position++;
		}

		// Remove it
		// Special case for the first node
		if (p == head)
			head = p.next;
		else
			prev.next = p.next;

		// If the last node has been removed, update tail
		if (p == tail)
			tail = prev;

		// update size
		size--;

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

		// Find the corresponding node
		Node p = head;
		Node prev = head;
		int position = 0;

		while (p != null && position != index) {
			prev = p;
			p = p.next;
			position++;
		}

		// Add a node between prev and p
		// Special case (first node)
		if (p == head) {
			head = new Node(o);
			head.next = p;
		} else {
			Node q = new Node(o);
			prev.next = q;
			q.next = p;
		}

		// Update tail if necessary
		if (tail == null) // the list was empty
			tail = head;
		else if (prev == tail) // the node was added at the end of the list
			tail = prev.next;

		// Update size
		size++;

		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 */
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			// o is a LinkedList (because of erasure, this statement generates a
			// warning)
			MyLinkedList<E> otherList = (MyLinkedList<E>) o;
			// if the number of elements is not the same, this and o are not the
			// same
			if (otherList.size != this.size)
				return false;
			// Check the elements one by one
			Node p, q;
			p = this.head;
			q = otherList.head;
			while (p != null) {
				if (!p.item.equals(q.item))
					return false;
				p = p.next;
				q = q.next;
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
		private Node p; // next node to visit

		private MyLinkedList<E> list;

		private Node lastVisitedNode; // Node most recently visited

		// by the iterator
		// is null if just removed
		private Node prevToLastVisitedNode; // Node before the most

		// recently visited node

		/**
		 * Create an iterator for a MyLinkedList
		 */
		public MyIterator(MyLinkedList<E> list) {
			this.list = list;
			p = list.head;
			lastVisitedNode = null;
		}

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			return (p != null);
		}

		/**
		 * Return the current element in the list and move to the next element
		 */
		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			if (lastVisitedNode != null) { // prev doesn't change if
				// lastVisited has been removed
				prevToLastVisitedNode = lastVisitedNode;
			}
			lastVisitedNode = p;
			E item = p.item;
			p = p.next;
			return item;
		}

		/**
		 * Remove the object currently pointed at by the iterator
		 */
		public void remove() {
			if (lastVisitedNode == null) {
				throw new IllegalStateException();
			}
			if (prevToLastVisitedNode == null) { // first node
				list.head = lastVisitedNode.next;
			} else {
				prevToLastVisitedNode.next = lastVisitedNode.next;
			}
			if (lastVisitedNode.next == null) { // tail has been removed
				list.tail = prevToLastVisitedNode;
			}
			lastVisitedNode = null;
			list.size--;
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
