// Definition of the Cow class
// A Cow is a Bovine that makes specific noises

public class Cow extends Bovine
{
  // Constructor
  public Cow()
  {
    super("A cow is a bovine that looks passively at passing trains");
  }

  // We need to override speak if we want to be able to
  // instantiate a Buffalo
  public void speak()
  {
    System.out.println("Help me! I have been tipped and I can't get up");
  }
}

