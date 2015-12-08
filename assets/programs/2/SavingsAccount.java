/**
 * A SavingsAccount is a RegularAccount that credits interest to the account if
 * the balance is above some minimum.
 */
public class SavingsAccount extends RegularAccount {

	// instance variables
	private double interestRate; // interest rate; 0.05 means 5%

	private double minBalance; // minimum account balance to receive interest

	/**
	 * Creates a new SavingsAccount.
	 * 
	 * @param ownerName
	 *            the name of the account owner.
	 * @param interestRate
	 *            the yearly interest rate of this savings account.
	 * @param minBalance
	 *            the minimum balance that must be kept on the account.
	 */
	public SavingsAccount(String ownerName, double interestRate,
			double minBalance) {
		super(ownerName);
		this.interestRate = interestRate;
		this.minBalance = minBalance;
	}

	/**
	 * Credits interest if current account balance is sufficient
	 */
	public void creditInterest() {
		if (this.getBalance() >= minBalance) {
			this.deposit(this.getBalance() * interestRate);
		}
	}

	/**
	 * Gets a string representation of this savings account.
	 * 
	 * @return a string representation of the savings account.
	 */
	public String toString() {
		java.text.NumberFormat p = java.text.NumberFormat.getPercentInstance();
		java.text.NumberFormat c = java.text.NumberFormat.getCurrencyInstance();
		return "Savings Account[" + this.ownerName + ", " + this.accountNumber
				+ ", " + c.format(this.balance) + ", "
				+ p.format(this.interestRate) + ", "
				+ c.format(this.minBalance) + "]";
	}

}
