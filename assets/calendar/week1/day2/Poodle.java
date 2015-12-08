// A Poodle is a Critter that makes a noise of a Poodle

public class Poodle extends Critter implements Trainable, Sellable {
	public Poodle() {
		super("A poodle is a dog with a funny haircut.");
	}

	public void speak() {
		System.out.println("I want a new haircut!");
	}

	@Override
	public void fetch() {
		System.out.println("It is fun to play fetch.");
	}

	@Override
	public void rollOver() {
		System.out.println("Roll over!");
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 500;
	}
}
