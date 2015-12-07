// A Poodle is a Critter that makes a noise of a Poodle

public class Poodle extends Critter
{
  // constructor
  public Poodle()
  {
    super("A poodle is a small dog with a funny haircut");
  }

  // We must override speak if we want Poodle to be instantiated
  public void speak()
  {
    System.out.println("Yap, yap, yap");
  }
}
