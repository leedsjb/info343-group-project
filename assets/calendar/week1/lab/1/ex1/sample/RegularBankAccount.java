/** 
 * A simple model of a Bank Account 
 * @author CSC 143
 */

public class RegularBankAccount implements BankAccount {
	// Add instance variables as you see fit

	/**
	 * Creates a new bank account with a zero balance and a unique account number
	 * 
	 * @param ownerName
	 *            the name of the person who owns this account
	 */
	public RegularBankAccount(String ownerName) {
	}

	/**
	 * Assigns this account a new unique account number
	 */
	private void assignNewAccountNumber() {
	}

	/**
	 * Returns the current balance.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
	}

	/**
	 * Deposits into account a given amount
	 * 
	 * @param amount
	 *            the amount to deposit
	 * @return whether or not the transaction was successful
	 */
	public boolean deposit(double amount) {
	}

	/**
	 * Withdraws from account a given amount
	 * 
	 * @param amount
	 *            the amount to withdraw
	 * @return whether or not the transaction was successful
	 */
	public boolean withdraw(double amount) {
	}

	/**
	 * A helper method that adds its argument to the balance, if it doesn't
	 * cause overdraft.
	 * 
	 * @param amount
	 *            the amount to add to the balance (negative to withdraw)
	 * @return whether or not the transaction was successful
	 */
	private boolean updateBalance(double amount) {
	}

	/**
	 * Returns a string representation of the account, e.g. for printing out
	 * 
	 * @return a string representation of the account
	 */
	public String toString() {
	}
}
