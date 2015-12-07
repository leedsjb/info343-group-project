
/**
 * An Animal has a name and can make a noise.
 */
public class Animal {
    // instance variables
    private String name;

    /**
     * Constructor an Animal with the given name
     */
    public Animal(String name) {
        this.name = name;
    }

    /** Return the noise this animal makes */
    public String noise() {
        return "?";
    }
}
