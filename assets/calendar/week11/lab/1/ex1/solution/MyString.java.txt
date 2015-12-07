/**
 * A simple class to describe a string. Don't use the String class directly to
 * be able to define a hashCode method
 */

public class MyString {

	// The string of this MyString object
	private String s;

	/**
	 * Constructs a MyString object with a given string
	 * 
	 * @param s
	 *            the string to use to construct this MyString object
	 * @throws IllegalArgumentException
	 *             if s is null
	 */
	public MyString(String s) {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		this.s = s;
	}

	/**
	 * Returns a description of this MyString object
	 * 
	 * @return a description of this MyString object
	 */
	public String toString() {
		return this.s;
	}

	/**
	 * Gets the hash code of this MyString (always as a non negative integer)
	 * 
	 * @return the hash code of this MyString.
	 */
	public int hashCode() {
		if (this.s.length() == 0) {
			return 0;
		} else {
			// Rank in the alphabet of the first letter
			char c = Character.toUpperCase(this.s.charAt(0));
			if (Character.isLetter(c)) {
				return c - 'A' + 1;
			} else {
				return 'Z' - 'A' + 2;
			}
		}
	}

	/**
	 * Is this MyString equal to the given object?
	 * 
	 * @param o
	 *            the object to compare this MyString object with
	 * @return true if o is equal to this MyString, or false otherwise
	 */
	public boolean equals(Object o) {
		if (o != null && o.getClass() == getClass()) {
			MyString m = (MyString) o;
			return m.s.equals(s);
		} else {
			return false;
		}
	}
}
