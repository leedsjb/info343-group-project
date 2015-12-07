/**
 * Interface for any Customer object.
 */

public interface Customer {

    /** Change the address of this customer
     * @param address new customer address
     */
    public void setAddress(String address);

    /** Get the customer's name
     * @return name of this customer
     */
    public String getName();

    /** Get the customer's address
     * @return address of this customer
     */
    public String getAddress();

}
