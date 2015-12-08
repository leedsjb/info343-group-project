public class TestCritter {
	// Write description of and sound produced by Critter c.
	public static void writeInfo(Critter c) {
		System.out.println("Dynamic type = " + c.getClass());
		// getClass from Object returns the
		// dynamic type of the variable
		c.describe();
		c.speak();
		System.out.println(c);
		// same as
		// System.out.println(c.toString());
		// don't confuse instanceof with getClass
		System.out.println("c.getClass() == Trainable.class is "
				+ (c.getClass() == Trainable.class));
		System.out.println("c instanceof Trainable is "
				+ (c instanceof Trainable));
		if (c instanceof Trainable) {
			Trainable t = (Trainable) c;
			t.fetch();
			t.rollOver();
		}
		// price of the critter
		if (c instanceof Sellable) {
			Sellable s = (Sellable) c;
			System.out.println("Price = $" + s.getPrice());
		}
	}

	// Test critter classes
	public static void main(String[] args) {
		// Create a poodle, a buffalo, a cow and a bird
		Critter[] a = { new Poodle(), new Buffalo(), new Cow() };
		// a[0] has static type = Critter
		// a[0] has dynamic type = Poodle
		// Call writeInfo for each critter
		for (Critter c : a) {
			writeInfo(c);
			System.out.println();
		}

	}
}
