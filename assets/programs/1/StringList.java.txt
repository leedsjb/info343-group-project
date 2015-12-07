/**
 * StringList - Example of implementing a collection with an array *
 */
public class StringList {

    // constant - default capacity of a new StringList if none specified
    private static final int DEFAULT_CAPACITY = 50;

    // instance variables
    private String[] strings;       // Items in this StringList are stored
    private int      size;          //   in strings[0..size-1].

    /** Construct new StringList with the default capacity */
    public StringList() {
        init(DEFAULT_CAPACITY);
    }

    /** Construct new StringList with the specificed capacity */
    public StringList(int capacity) {
        init(capacity);
    }

    // Initialize this StringList with the specificed capacity
    private void init(int capacity) {
        strings = new String[capacity];
        size = 0;
    }

    /** = "this StringList is empty" */
    public boolean isEmpty() {
        return size == 0;
    }

    /** = "this StringList is full" */
    public boolean isFull() {
        return strings.length == size;
    }

    /** = number of elements in this StringList */
    public int size() {
        return size;
    }

    /**
     * Add new String to this StringList.
     * @param str String to be added
     */
    public void add(String str) {
        strings[size] = str;
        size++;
    }

    /** Return position of str in this StringList if present,
     *  otherwise, return -1 */
    public int contains(String str) {
        for (int k = 0; k < strings.length; k++) {
            if (str.equals(strings[k])) {
                return k;
            }
        }
        return -1;
    }

    /**
     * Return the string stored at at position pos in this StringList.
     * @return String at position pos
     */
    public String get(int pos) {
        return strings[pos];
    }

    /**
     * Remove the string stored at position pos in this StringList.
     * @return String that was at position pos.
     */
    public String remove(int pos) {
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
