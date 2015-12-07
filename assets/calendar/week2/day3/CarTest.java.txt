public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car("Ford", 2000, "Sara", 30);
		Car c2 = c1;
		Car c3 = new Car("Ford", 2000, "Sara", 30);

		// equals from Object tests for aliases
		// -> override equals in Car to compare contents
		System.out.println("Compare two cars");
		System.out.println("c1.equals(null) = " + c1.equals(null));
		System.out.println("c1.equals(c1) = " + c1.equals(c1));
		System.out.println("c1.equals(c2) = " + c1.equals(c2));
		System.out.println("c1.equals(c3) = " + c1.equals(c3));

		System.out.println("\nCompare two fancy cars");
		FancyCar fc1 = new FancyCar("Ford", 2000, 200, "Sara", 30);
		FancyCar fc2 = fc1;
		FancyCar fc3 = new FancyCar("Ford", 2000, 200, "Sara", 30);
		System.out.println("fc1.equals(null) = " + fc1.equals(null));
		System.out.println("fc1.equals(fc1) = " + fc1.equals(fc1));
		System.out.println("fc1.equals(fc2) = " + fc1.equals(fc2));
		System.out.println("fc1.equals(fc3) = " + fc1.equals(fc3));

		System.out.println("\nCompare a car and a fancy car");
		System.out.println("fc1.equals(c1) = " + fc1.equals(c1));
		System.out.println("c1.equals(fc1) = " + c1.equals(fc1));

		// tests the clone method
		// shallow copy
		System.out.println("\nClone method:\nShallow copy");
		c1.setDeepCopy(false);
		Car copy = (Car) c1.clone();
		// copy and c1 should be the same
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);
		// copy is a shallow copy of c1
		// change the age of the owner of copy
		copy.getOwner().setAge(35);
		// the age of the owner of c1 should change as well
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);

		// deep copy
		System.out.println("\nDeep copy");
		c1.setDeepCopy(true);
		copy = (Car) c1.clone();
		// copy and c1 should be the same
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);
		// copy is a shallow copy of c1
		// change the age of the owner of copy
		copy.getOwner().setAge(40);
		// the age of the owner of c1 should not have changed
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);

		// tests the copy constructor (see code of the constructor in the Car
		// class)
		// shallow copy
		System.out.println("\nCopy constructor:\nShallow copy");
		c1.getOwner().setAge(30); // reset the age of c1 to 30
		copy = new Car(c1, false); // false for a shallow copy
		// copy and c1 should be the same
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);
		// copy is a shallow copy of c1
		// change the age of the owner of copy
		copy.getOwner().setAge(35);
		// the age of the owner of c1 should change as well
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);

		// deep copy
		System.out.println("\nDeep copy");
		copy = new Car(c1, true); // true for a deep copy
		// copy and c1 should be the same
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);
		// copy is a shallow copy of c1
		// change the age of the owner of copy
		copy.getOwner().setAge(40);
		// the age of the owner of c1 should not have changed
		System.out.println("c1 = " + c1);
		System.out.println("copy = " + copy);

	}

}
