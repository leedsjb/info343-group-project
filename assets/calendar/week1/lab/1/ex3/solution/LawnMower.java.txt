import java.text.DecimalFormat; // for formatting

/**
 * A class to represent a lawn mower
 */

public class LawnMower implements Driveable {

    /** Maximum speed (in mph) */
    public static final double MAX_SPEED = 10;

    // Instance fields
    private Direction dir; // the direction the lawn mower is moving
    private boolean engineIsRunning; // is the engine running?
    private double speed; // the current speed of the lawn mower


    /**
     * Create a LawnMower at rest
     */
    public LawnMower()
    {
        this.dir = new Direction(0); // going east initially
        this.engineIsRunning = false; // not started
        this.speed = 0; // no initial speed
    }

    // Implement the Driveable interface

    /**
     * start the engine
     * @return true (assume that it always works)
     */
    public boolean start()
    {
        this.engineIsRunning = true;
	// start from rest
	this.speed = 0;
        return this.engineIsRunning;
    }

    /**
     * stop the engine
     * @return true (assume that it always works)
     */
    public boolean stop()
    {
        this.engineIsRunning = false;
        this.speed = 0;
        return this.engineIsRunning;
    }

    /**
     * Set the speed, if the new speed is within the speed range
     * @param speed the speed to set the lawn mower speed to
     * @return the new speed of the car
     */
    public double cruise(double speed)
    {
        // Change the speed if possible
        if (speed>=0 && speed<=MAX_SPEED)
            this.speed = speed;

        return this.speed;
    }

    /**
     * Turn this lawn mower in a given direction
     * @param dir the new direction of the lawn mower
     * @return true (assume that it always works)
     */
    public boolean turn(Direction dir)
    {
        this.dir = dir;
        return true;
    }

    /**
     * Describe the state of a LawnMower
     * @return the string that describes the lawnmower
     */
    public String toString()
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");

        String description;
        description = "Lawn mower status\n";
        description += "Engine: " + ((this.engineIsRunning)?"On":"Off") + "\n";
        description += "Speed: " + twoDigits.format(this.speed) + "\n";
        description += "Direction: " + this.dir.toString();

        return description;
    }
}





