// Definition of the Critter class
// Must be abstract since we can't define a concrete Critter

public abstract class Critter
{
  // description of this Critter
  private String description;

  // Construct Critter with description s.
  public Critter(String s)
  {
    description = new String(s);
  }

  // Write Critter description
  public void describe( )
  {
    System.out.println(description);
  }

  // Write noise made by this Critter to cout
  // abstract since we can't say what noise a Critter makes
  abstract void speak();
}
