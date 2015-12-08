public class Car implements Cloneable {
	private int weight;
	private String make;
	private Person owner;
	private boolean deepCopy;

	public Car(String make, int weight, String ownerName, int ownerAge) {
		this.make = make;
		this.weight = weight;
		this.owner = new Person(ownerName, ownerAge);
	}
	
	// if not using clone, provide a copy constructor
	// Constructs a car that is a copy of the given car
	public Car(Car c, boolean deepCopy) {
		this.deepCopy = deepCopy;
		// shallow copy
		this.make = c.make;
		this.weight = c.weight;
		this.owner = c.owner;
		if (deepCopy) {
			// no need to copy the strings since the String class
			// is immutable
			this.owner = new Person(c.owner.getName(), 
					                c.owner.getAge());
		}
	}

	// override of equals from Object
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Car that = (Car) obj;
			return this.weight == that.weight && this.make.equals(that.make);
		} else {
			return false;
		}
	}

	// gets the owner of the car
	public Person getOwner() {
		return owner;
	}

	// returns a string representation of the car
	public String toString() {
		return "make = " + make + ", weight = " + weight + ", owner = "
				+ owner.getName() + ", " + owner.getAge();
	}

	// returns a copy of this car
	public Object clone() {
		Object copy = null;
		try {
			// clone from Object makes a shallow copy
			copy = super.clone();
			if (deepCopy) {
				Person copyOwner = new Person(owner.getName(), 
						owner.getAge());
				((Car)copy).owner = copyOwner;
			}
		} catch (CloneNotSupportedException e) {
			// this never happens
		}
		return copy;
	}

	public void setDeepCopy(boolean b) {
		deepCopy = b;
	}

}
