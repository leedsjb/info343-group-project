/** 
 * A simple model of a Bank Account 
 * @author CSC 143
 */

public class RegularBankAccount implements BankAccount {
	private double balance; // the current balance of the account

	private String ownerName; // the name of the person who owns this account

	private int accountNumber; // the account number of this account

	private static int nextAccountNumber = 1; // next available account number

	/**
	 * Creates a new bank account with a zero balance and a unique account number
	 * 
	 * @param ownerName
	 *            the name of the person who owns this account
	 */
	public RegularBankAccount(String ownerName) {
		this.ownerName = ownerName;
		this.balance = 0.0;
		this.assignNewAccountNumber();
	}

	/**
	 * Assigns this account a new unique account number
	 */
	private void assignNewAccountNumber() {
		java.util.Random rand = new java.util.Random();
		this.accountNumber = RegularBankAccount.nextAccountNumber;
		RegularBankAccount.nextAccountNumber++;
	}

	/**
	 * Returns the current balance.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Deposits into account a given amount
	 * 
	 * @param amount
	 *            the amount to deposit
	 * @return whether or not the transaction was successful
	 */
	public boolean deposit(double amount) {
		return this.updateBalance(amount);
	}

	/**
	 * Withdraws from account a given amount
	 * 
	 * @param amount
	 *            the amount to withdraw
	 * @return whether or not the transaction was successful
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
	 * @return whether or not the transaction was successful
	 */
	private boolean updateBalance(double amount) {
		if (this.balance + amount < 0) {
			// don't change the balance, if this would overdraw it. print an
			// error message instead.
			System.out.println("Sorry, you don't have that much money to withdraw.");
			return false;
		} else {
			// update the balance
			this.balance = this.balance + amount;
			return true;
		}
	}

	/**
	 * Returns a string representation of the account, e.g. for printing out
	 * 
	 * @return a string representation of the account
	 */
	public String toString() {
		return "RegularBankAccount#" + this.accountNumber + " (owned by "
				+ this.ownerName + "): current balance: " + this.balance;
	}
}
