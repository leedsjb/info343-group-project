
/**
 * An PreferredCustomer gets a special discount.
 */
public class PreferredCustomer implements Customer {
    /**
     * Construct a PreferredCustomer with the given name and address
     * and a 10% discount.
     */
    public PreferredCustomer(String name, String address) {
        this.name = name;
        this.address = address;
        this.discount = 0.1;
    }

    /** Change the address of this customer */
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

    /** Set this customer's discount */
    public void setDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    // instance variables
    private String name;        // customer's name
    private String address;     // customer's address
    private double discount;    // % discount - 0.10 means 10%, etc.
}
