/**
 * CheckingAccount: a version of a bank account assesses a service charge when
 * needed.
 */
public class CheckingAccount extends RegularAccount {

	// instance variables
	private double lowBalance; // low balance since account created or last
								// service charge was deducted

	/**
	 * Creates a new CheckingAccount.
	 * 
	 * @param ownerName
	 *            the name of the owner of the account
	 * @param initialBalance
	 *            the initial balance of the account
	 */
	public CheckingAccount(String ownerName, double initialBalance) {
		super(ownerName);
		this.balance = initialBalance;
		this.lowBalance = initialBalance;
	}

	/**
	 * Deducts a service charge if the account balance has gotten too low since
	 * the last time a service charge was deducted (or the account created,
	 * whichever comes first).
	 * 
	 * @param minBalance
	 *            minimum account balance before service charge applies.
	 * @param serviceCharge
	 *            amount to deduct if charge applies.
	 */
	public void deductFees(double minBalance, double serviceCharge) {
		if (this.lowBalance < minBalance) {
			this.withdraw(serviceCharge);
		}
		this.lowBalance = this.balance;
	}

	/**
	 * Returns a string representation of the checking account.
	 * 
	 * @return a string representation of the checking account.
	 */
	public String toString() {
		java.text.NumberFormat c = java.text.NumberFormat.getCurrencyInstance();
		return "Checking Account[" + this.ownerName + ", " + this.accountNumber
				+ ", " + c.format(this.balance) + ", "
				+ c.format(this.lowBalance) + "]";
	}

	/**
	 * Updates the balance of the account and possibly the low balance.
	 * 
	 * @return whether the operation was successful or not.
	 */
	protected boolean updateBalance(double amount) {
		boolean OK = super.updateBalance(amount);
		if (this.balance < this.lowBalance) {
			this.lowBalance = this.balance;
		}
		return OK;
	}
}
