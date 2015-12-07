
/**
 * An OrdinaryCustomer is a member of the anonymous masses and gets
 * no special treatment.
 */
public class OrdinaryCustomer implements Customer {
    /**
     * Construct an OrdinaryCustomer with the given name and address
     *
     * @param name the name of the customer
     * @param address the address of the customer
     */
    public OrdinaryCustomer(String name, String address) {
        this.name = name;
        this.address = address;
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

    /** Return a description of this customer */
    public String toString()
    {
	return this.name + " " + this.address;
    }

    // instance variables
    private String name;        // customer's name
    private String address;     // customer's address
}
