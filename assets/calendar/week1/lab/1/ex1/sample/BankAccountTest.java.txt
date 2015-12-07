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
	}

	/**
	 * Sets up the test case before testing each fixture
	 */
	protected void setUp() {
	}

	/**
	 * Cleans up the test case after testing a fixture
	 */
	protected void tearDown() {
	}

	/**
	 * A newly created bank account has an owner and 0 balance
	 */
	public void testGetBalance() {
	}

	/**
	 * Adds to and withdraws from the account, checking that everything goes as
	 * planned.
	 */
	public void testDepositAndWithdraw() {
	}

	/**
	 * Runs the test
	 */
	public static Test suite() {
		return new TestSuite(BankAccountTest.class);
	}

}
