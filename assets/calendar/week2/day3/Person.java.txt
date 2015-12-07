public class Person {
	private int age;
	private String name;

	public Person(String n, int a) {
		name = n;
		age = a;
	}
	
	/**
	 * A copy constructor
	 */
	public Person(Person p) {
		this.age = p.age;
		this.name = p.name; // shallow copy but fine
		// since Strings are immutable
	}

	public String toString() {
		return "name = " + name + ", age = " + age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
