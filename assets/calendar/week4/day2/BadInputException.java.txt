/**
 * An exception thrown in case of bad input
 * Since it is derived from Exception (and not
 * from RuntimeException), it is a checked 
 * exception
 * @author CSC 143
 *
 */
public class BadInputException extends Exception {
	public BadInputException() {
	}
	
	public BadInputException(String s) {
		super(s);
	}
}
