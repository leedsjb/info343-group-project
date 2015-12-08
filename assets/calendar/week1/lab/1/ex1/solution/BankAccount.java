/**
 * A simple model of a bank account
 * @author CSC 143
 */
public interface BankAccount {
	/**
	 * Returns the current balance.
	 * 
	 * @return the current balance
	 */
	public double getBalance(); 

	/**
	 * Deposits into account a given amount
	 * 
	 * @param amount
	 *            the amount to deposit
	 * @return whether or not the transaction was successful
	 */
	public boolean deposit(double amount);

	/**
	 * Withdraws from account a given amount
	 * 
	 * @param amount
	 *            the amount to withdraw
	 * @return whether or not the transaction was successful
	 */
	public boolean withdraw(double amount); 


}
