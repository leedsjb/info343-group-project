// Definition of the Cow class
// A Cow is a Bovine that makes specific noises

public class Cow extends Bovine implements Sellable{
	// Constructor
	public Cow() {
		super("Fun fact: a cow is a bovine that has four stomachs.");
	}

	// We need to override speak if we want to be able to
	// instantiate a Buffalo
	public void speak() {
		System.out.println(
	"Help me! Some kid just tipped me.");
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 2000;
	}
}
