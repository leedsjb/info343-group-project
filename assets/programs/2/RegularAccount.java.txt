/**
 * A Bank Account
 */

public class RegularAccount implements BankAccount {

	protected double balance; // the current balance of the account

	protected String ownerName; // the name of the person who owns this account

	protected int accountNumber; // the account number of this account

	private static int nextAccountNumber = 1; // the next available account
												// number

	/**
	 * Creates a new bank account with a zero balance and a unique account
	 * number.
	 * 
	 * @param ownerName
	 *            the name of the person who owns this account.
	 */
	public RegularAccount(String ownerName) {
		this.ownerName = ownerName;
		this.balance = 0.0;
		this.assignNewAccountNumber();
	}

	/**
	 * Assigns this account a new unique account number
	 */
	private void assignNewAccountNumber() {
		this.accountNumber = RegularAccount.nextAccountNumber;
		RegularAccount.nextAccountNumber++;
	}

	/**
	 * Gets the current balance.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Deposits into account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 * @return whether or not the transaction was successful
	 */
	public boolean deposit(double amount) {
		return this.updateBalance(amount);
	}

	/**
	 * Withdraws from account.
	 * 
	 * @param amount
	 *            the amount to withdraw
	 * @return whether or not the transaction was successful/
	 */
	public boolean withdraw(double amount) {
		return this.updateBalance(-amount);
	}

	/**
	 * A helper method that adds its argument to the balance, if it doesn't
	 * cause overdraft.
	 * 
	 * @param amount
	 *            the amount to add to the balance (negative to withdraw)
	 * @return whether or not the transaction was successful.
	 */
	protected boolean updateBalance(double amount) {
		if (this.balance + amount < 0) {
			// don't change the balance, if this would overdraw it. print an
			// error message instead.
			System.out
					.println("Sorry, you don't have that much money to withdraw.");
			return false;
		} else {
			// update the balance
			this.balance = this.balance + amount;
			return true;
		}
	}

	/**
	 * Computes a string representation of the account, e.g. for printing out
	 * 
	 * @return a string representation of the account.
	 */
	public String toString() {
		return "BankAccount#" + this.accountNumber + " (owned by "
				+ this.ownerName + "): current balance: " + this.balance;
	}
}