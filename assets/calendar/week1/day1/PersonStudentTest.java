import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test of the Person and Student classes
 * 
 * @author CSC 143
 *
 */
public class PersonStudentTest {

	public static void main(String[] args) {
		
		// Using String.format
		String st = "Thursday";
		int day = 1;
		double temperature = 72;
		// On Thursday 1st, the temperature is 72.0 F
		// % means a placeholder -> where a value
		// of a variable is inserted
		// %s -> a string 
		// %d -> an integer
		// %.1f -> a double to 1 decimal place
		String m = String.format(
				"On %s %dst, the temperature is %.1f", 
				st, day, temperature);
		System.out.println(m);
		
		Student s = new Student("Sara", 29, 3.9);
		s.speak();

		Person p = s;
		// p has static type Person. It never changes.
		// p has dynamic type Student. It may change. For instance,
		// by writing p = new Person("Nick", 32); -> p would have
		// dynamic type Person.
		// Or even the dynamic type may not be defined, e.g.
		// p = null;
		p.speak();
		// compiles because speak is in Person
		// at run time, the JVM looks for speak in the dynamic
		// type = Student. If not found (not the case here), it moves
		// up to Person.
	}

	@Test
	public void testStudentPerson() {
		Person p = new Student("Sara", 29, 3.96);
		String s = p.toString();
		assertTrue(s.contains("Sara"));
		assertTrue(s.contains("29"));
		assertTrue(s.contains("4.0"));
	}

}







