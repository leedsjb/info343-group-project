/**
 * A simple class to describe a string. Don't use the String class directly to
 * be able to define a hashCode method
 */

public class MyString {

	// The string of this MyString object
	private String s;

	/**
	 * Construct a MyString object with a given string
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
	}
}