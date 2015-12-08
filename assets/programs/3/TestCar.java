import java.awt.Color;

import junit.framework.TestCase;

/**
 * Test the use of equals and toString in the Car and FancyCar classes
 * 
 * @author CSC 143
 */

public class TestCar extends TestCase {
	/**
	 * Tests equals in Car and FancyCar
	 */
	public void testEquals() {

		Car c1 = new Car(Color.red, 2000, "Ford");
		Car c2 = new Car(Color.red, 2000, "Nissan");
		assertFalse(c1.equals(null));
		assertTrue(c1.equals(c1));
		assertFalse(c1.equals(c2));
		
		// What about cloning?
		Car copy = (Car) c1.clone();
		assertTrue(copy.equals(c1));
		

		FancyCar fc1 = new FancyCar(Color.red, 2000, "Ford", 200);
		FancyCar fc2 = new FancyCar(Color.blue, 2000, "Ford", 200);
		assertFalse(fc1.equals(null));
		assertTrue(fc1.equals(fc1));
		assertFalse(fc1.equals(fc2));
		assertFalse(c1.equals(fc1));
		assertFalse(fc1.equals(c1));
		
		// What about cloning?
		FancyCar fancyCopy = (FancyCar) fc1.clone();
		assertTrue(fancyCopy.equals(fc1));
	}
}