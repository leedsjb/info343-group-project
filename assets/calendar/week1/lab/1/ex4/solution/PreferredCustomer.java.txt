
/**
 * A PreferredCustomer gets a special discount (add a double field discount and
 * a set and get method to access the discount)
 */
public class PreferredCustomer implements Customer {
    // Would it better to extend OrdinaryCustomer instead?
    // How would you do it?

    // instance variables
    private String name;        // customer's name
    private String address;     // customer's address
    private double discount;    // % discount - 0.10 means 10%, etc.

    /**
     * Construct a PreferredCustomer with the given name and address
     * and a 10% discount.
     *
     * @param name the name of the customer
     * @param address the address of the customer
     */
    public PreferredCustomer(String name, String address) {
        this.name = name;
        this.address = address;
        this.discount = 0.1;
    }

    /**
     * Change the address of this customer
     *
     * @param address the new address of the customer
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Return the name of this customer */
    public String getName() {
        return this.name;
    }

    /** Return the address of this customer */
    public String getAddress() {
        return this.address;
    }

    /**
     * Set this customer's discount (if valid)
     * A valid discount is between 0 and 0.9
     *
     * @param newDiscount the new discount for this customer
     */
    public void setDiscount(double newDiscount) {
        if (newDiscount >=0 && newDiscount <=0.9)
	    this.discount = newDiscount;
    }


    /**
     * get this customer's discount
     *
     * @return the customer's discount
     */
    public double getDiscount() {
	return this.discount;
    }

    /** Return a description of this customer */
    public String toString()
    {
	// to write the discount as a percentage
	java.text.NumberFormat nf = java.text.NumberFormat.getPercentInstance();
	return this.name + " " + this.address + " " + nf.format(this.discount);
    }
}
