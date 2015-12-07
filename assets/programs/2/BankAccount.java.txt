/**
 * BankAccount: an interface that defines the basic operations of a bank
 * account.
 */
public interface BankAccount {
	/**
	 * Gets the balance of this account.
	 * 
	 * @return the balance of the account.
	 */
	public double getBalance();

	/**
	 * Deposits an amount on this account.
	 * 
	 * @param amount
	 *            the amount to deposit.
	 * @return whether or not the operation was successful.
	 */
	public boolean deposit(double amount);

	/**
	 * Withdraws an amount from this account.
	 * 
	 * @param amount
	 *            the amount to withdraw.
	 * @return whether or not the operation was successful.
	 */
	public boolean withdraw(double amount);
}
