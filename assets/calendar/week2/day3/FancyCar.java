/**
 * A FancyCar is a Car with a top speed
 * 
 * @author CSC 143
 * 
 */
public class FancyCar extends Car {
	private double topSpeed;

	public FancyCar(String make, int weight, double topSpeed, 
			String name, int age) {
		super(make, weight, name, age);
		this.topSpeed = topSpeed;
	}

	@Override
	public boolean equals(Object obj) {
		// if (obj instanceof FancyCar) {
		if (obj != null && obj.getClass() == this.getClass()) {
			FancyCar fc = (FancyCar) obj;
			return fc.topSpeed == this.topSpeed && super.equals(obj);
		} else {
			return false;
		}
	}
}
