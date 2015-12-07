/**
 * A Cat is an Animal whose noise is a meow.
 */
public class Cat extends Animal {
    /** Construct a new Cat with the given name */
    public Cat(String name){
        super(name);
    }
    /** Return the noise a cat makes */
    public String noise() {
        return "meow";
    }
}