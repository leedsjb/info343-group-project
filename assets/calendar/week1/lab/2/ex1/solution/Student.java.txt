// A student is Person with a gpa


public class Student extends Person
{
  private double gpa;

  // Constructors
  public Student(){
   // Person() called automatically
   gpa = 3.5;}
   public Student(String s,int a,double g)
  {
    //Call the constructor Person (s,a)
    super(s,a); //Don't write Person(s,a)
    setGPA(g);
  }

   // Access the variable gpa
   public void setGPA(double g)
   {
    if (g>=0 && g<=4.0) gpa=g;
   }
   public double getGPA()
   {
    return gpa;
   }

   // Let the student speak: override speak from Person
   public void speak()
   {
     super.speak();
     System.out.println("My gpa is "+gpa);
   }
}
