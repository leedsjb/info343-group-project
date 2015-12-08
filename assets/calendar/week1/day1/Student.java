/**
 * A student is a person with a gpa
 * 
 * @author CSC 143
 *
 */
public class Student extends Person {
	// gpa of the student
	private double gpa;

	/**
	 * Creates a student given a name, age and gpa
	 * 
	 * @param name
	 *            the name of the student
	 * @param age
	 *            the age of the student
	 * @param gpa
	 *            the gpa of the student
	 */
	public Student(String name, int age, double gpa) {
		// build the Person foundation of the student
		// -> call the superclass constructor
		super(name, age); // MUST BE THE FIRST LINE
		this.gpa = gpa;
	}

	/**
	 * Overrides speak from Person so that the gpa is also printed
	 */
	@Override
	public void speak() {
		super.speak(); // call speak in Person
		System.out.println("gpa = " + gpa);
	}
	
	/**
	 * Returns the name, age and gpa of the student
	 * in a string
	 */
	@Override
	public String toString() {
		return super.toString() + ", gpa = " + 
	           String.format("%.1f", gpa);
	}

}









