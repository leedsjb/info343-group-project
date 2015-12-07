// A person has a name, an age and can speak

public class Person
{
  public String name; // any name is OK
  private int age; // age is between 0 and 130

  // Default constructor
  public Person()
  {
    // Use the other constructor
    this("someone",20);
  }
  // Person with name n and age a (if valid)
  public Person(String n, int a)
  {
    name = n;
    setAge(a);
  }

  // Accessor methods
  public void setAge(int a)
  {
    if (a>=0 && a <=130) age = a;
  }
  public int getAge() {return age;}
  public void setName(String n) {name=n;}
  public String getName() {return name;}

  // Print the name of the person
  public void speak()
  {
    System.out.println("Hi, my name is "+name+" and I am "+age+
    ((age<=1)?" year":" years")+" old.");
  }
}
