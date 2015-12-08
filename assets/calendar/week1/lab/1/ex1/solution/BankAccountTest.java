import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * A suite of test cases to check the correctness of the RegularBankAccount class
 * 
 * @author CSC 143
 */

public class BankAccountTest extends TestCase {

	private RegularBankAccount a;

	/**
	 * Creates a test case to test the RegularBankAccount class
	 */
	public BankAccountTest() {
		super("Bank Account Test");
	}

	/**
	 * Sets up the test case before testing each fixture
	 */
	protected void setUp() {
		// not really needed here
		a = null; // make sure that a test is run from scratch
	}

	/**
	 * Cleans up the test case after testing a fixture
	 */
	protected void tearDown() {
		// not really needed here
		a = null; // don't leave anything behind after a test
	}

	/**
	 * A newly created bank account has an owner and 0 balance
	 */
	public void testGetBalance() {
		a = new RegularBankAccount("Steve Jobs");
		double b = a.getBalance();
		assertTrue(b == 0);
		String s = a.toString();
		assertTrue(s.indexOf("Steve Jobs") != -1);
	}

	/**
	 * Adds to and withdraws from the account, checking that everything goes as
	 * planned.
	 */
	public void testDepositAndWithdraw() {
		a = new RegularBankAccount("Bill Gates");
		boolean success = a.deposit(-100); // Nope!
		assertFalse(success);
		success = a.deposit(100); // OK
		assertTrue(success);
		double b = a.getBalance(); // should be 100
		assertTrue(b == 100);
		success = a.withdraw(200); // Nope!
		assertFalse(success);
		success = a.withdraw(75);
		assertTrue(success);
		b = a.getBalance();
		assertTrue(b == 25);
	}

	/**
	 * Runs the test
	 */
	public static Test suite() {
		return new TestSuite(BankAccountTest.class);
	}

}
