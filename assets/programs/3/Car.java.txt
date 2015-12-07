import java.awt.Color;

/**
 * A simple model of a car. A car is defined by its color, weight and make. This
 * class illustrates the use of toString and equals
 * 
 * @author CSC 143
 */
public class Car implements Cloneable {
	// the attributes of this car
	private Color color;

	private double weight;

	private String make;

	/**
	 * Creates a car given its color, weight and make
	 * 
	 * @param theColor
	 *            the color of this car
	 * @param theWeight
	 *            the weight of this car
	 * @param theMake
	 *            the make of this car
	 */
	public Car(Color theColor, double theWeight, String theMake) {
		this.color = theColor;
		this.weight = theWeight;
		this.make = theMake;
	}

	/**
	 * Returns a string representation of this car
	 * 
	 * @return a string representation of this car
	 */
	public String toString() {
		return this.color + ", " + this.weight + ", " + this.make;
	}

	/**
	 * Is this car equal to o? Two cars are equal if they have the same color,
	 * weight and make
	 * 
	 * @param o
	 *            the object to compare this car to
	 * @return true if this car is equal to o and false otherwise.
	 */
	public boolean equals(Object o) {
		// is o a car?
		if (o != null && o.getClass() == this.getClass()) {
			// don't do: if (o instanceof Car) {
			Car c = (Car) o;
			return (this.weight == c.weight && this.color.equals(c.color) && this.make
					.equals(c.make));
			// note the use of equals for color and make. Must do so
			// since both have a reference type.
		} else {
			return false;
		}
	}

	/**
	 * Returns a copy of this car
	 * 
	 * @return a copy of this car
	 */
	public Object clone() {
		Car copy = null;
		try {
			copy = (Car) super.clone();
		} catch (CloneNotSupportedException e) {
			// Should never happen, but the compiler can't figure it out
			throw new InternalError();
		}
		// Done since String and Color are immutable (no need for a deep copy)
		return copy;
	}
}
