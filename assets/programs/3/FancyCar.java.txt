import java.awt.Color;

/**
 * A FancyCar is a Car with a top speed
 * 
 * @author CSC 143
 */
public class FancyCar extends Car {
	// the top speed of this fancy car
	private double topSpeed;

	/**
	 * Creates a fancy car given its color, weight, make and top speed
	 * 
	 * @param theColor
	 *            the color of the fancy car
	 * @param theWeight
	 *            the weight of the fancy car
	 * @param theMake
	 *            the make of the fancy car
	 * @param theTopSpeed
	 *            the top speed of the fancy car
	 */
	public FancyCar(Color theColor, double theWeight, String theMake,
			double theTopSpeed) {
		super(theColor, theWeight, theMake);
		this.topSpeed = theTopSpeed;
	}

	/**
	 * Returns a string representation of this fancy car
	 * 
	 * @return a string representation of this fancy car
	 */
	public String toString() {
		return super.toString() + ", topSpeed = " + this.topSpeed;
	}

	/**
	 * Is this fancy car equal to o?
	 * 
	 * @param o
	 *            the object to compare this fancy car to
	 * @return true is this fancy car is equal to o, and false otherwise
	 */
	public boolean equals(Object o) {
		// is o a fancy car?
		if (o != null && o.getClass() == this.getClass()) {
			// don't do: if (o instanceof FancyCar) {
			FancyCar fc = (FancyCar) o;
			return (super.equals(o) && this.topSpeed == fc.topSpeed);
		} else {
			return false;
		}
	}
	
	// Do we need a clone? answer: No, but why does clone from Car suffice?
}