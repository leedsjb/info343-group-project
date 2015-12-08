// Test the use of Person and student

import javax.swing.*;

public class TestPersonStudent
{
  public static void main(String[] args)
  {
    Person p = new Person();
    Student s = new Student("Jane",25,3.9);
    // Let p and s speak
    p.speak();
    s.speak();

    // Illustrating dynamic binding
    Person[] group = new Person[2];
    group[0] = new Person("person in group",20);
    group[1] = new Student("student in group",25,4.0);
    for(int i=0; i<group.length; i++)
            group[i].speak(); // invokes speak in Person for i=0
                              // invokes speak in Student for i=1

  }
}
