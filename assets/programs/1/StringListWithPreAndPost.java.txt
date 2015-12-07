/**
 * StringList - Example of implementing a collection with an array *
 */

public class StringListWithPreAndPost {

    // constant - default capacity of a new StringList if none specified
    private static final int DEFAULT_CAPACITY = 50;

    // instance variables
    private String[] strings;       // Items in this StringList are stored
    private int      size;          //   in strings[0..size-1].

    /**
     * Construct new StringList with the default capacity
     * Precondition: none
     * Postcondition: an empty list is created
     */
    public StringListWithPreAndPost()
    {
        init(DEFAULT_CAPACITY);
    }

    /**
     * Construct new StringList with the specificed capacity
     * Precondition: capacity is a positive integer
     * Postcondition: an empty list is created (with the given capacity)
     * @param capacity the initial capacity of the list
     */
    public StringListWithPreAndPost(int capacity)
    {
        if (capacity<=0)
            throw new IllegalArgumentException("capacity is <=0");
        init(capacity);
    }

    // Create the String array with the specified dimension
    // Precondition: capacity is a positive integer
    // Postcondition: an array of the given dimension is created
    // capacity must be >0 (but we know what we are doing. Do we?)
    private void init(int capacity)
    {
        strings = new String[capacity];
        size = 0;
    }

    /**
     * Precondition: none
     * Postcondition result == this StringList is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Precondition: none
     * Postcondition result == this StringList is full
     */
    public boolean isFull()
    {
        return strings.length == size;
    }

    /**
     * Precondition: none
     * Postcondition result == the number of elements in this StringList
     */
    public int size()
    {
        return size;
    }

    /**
     * Add new String to this StringList.
     * Precondition: the list is not full
     * Postcondition: str has been added at the end of the list
     * @param str String to be added
     */
    public void add(String str)
    {
        if (size == strings.length)
            throw new java.lang.IndexOutOfBoundsException("List is full");
        strings[size] = str;
        size++;
    }

    /**
     * Precondition: none
     * Postcondition result == postion of str in this StringList (or -1 if not present)
     */
    public int contains(String str) {
        for (int k = 0; k < strings.length; k++) {
            if (str.equals(strings[k])) {
                return k;
            }
        }
        return -1;
    }

    /**
     * Precondition: pos>=0 AND pos<size()
     * Postcondition: result == string stored at at position pos in this StringList.
     */
    public String get(int pos) {
        if ( !(pos>=0 && pos<this.size()) )
            throw new java.lang.IndexOutOfBoundsException("List is full");
        return strings[pos];
    }

    /**
     * Precondition: pos>=0 AND pos<size()
     * Postcondition: the string stored at position pos in this StringList is removed and
     * @return the String at position pos
     */
    public String remove(int pos) {
        if ( !(pos>=0 && pos<this.size()) )
            throw new java.lang.IndexOutOfBoundsException("List is full");

        String result = strings[pos];

        // shift array elements from strings[pos+1] to
        // strings[size-1] left one position
        for (int k = pos; k < size-1; k++) {
            strings[k] = strings[k+1];
        }
        // decrease size and erase String reference in vacated position.
        size--;
        strings[size] = null;
        return result;
    }
}
