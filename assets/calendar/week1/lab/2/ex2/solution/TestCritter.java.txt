import javax.swing.*;

public class TestCritter
{
  // Write description of and sound produced by Critter c.
  public static void write_info(Critter c)
  {
    c.describe( );
    System.out.println("It makes the noise:  ");
    c.speak( );
    System.out.println("");
  }

  // Test critter classes
  public static void main(String[] args)
  {
    Poodle p = new Poodle();
    Buffalo b = new Buffalo();
    Cow  c = new Cow();
    Bird bird = new Bird();

    write_info(p);
    write_info(b);
    write_info(c);
    write_info(bird);
  }
}
