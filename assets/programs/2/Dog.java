/**
 * A Dog is an Animal whose noise is a woof.
 */
public class Dog extends Animal {
    /** Construct a new Dog with the given name */
    public Dog(String name){
        super(name);
    }
    /** Return the noise a dog makes */
    public String noise() {
        return "Woof!";
    }
}
