import java.text.DecimalFormat; // for formatting

/**
 * A class to represent a car
 */

public class Car implements Driveable {

    /** Maximum speed (in mph) */
    public static final double MAX_SPEED = 90;

    private Direction dir; // the direction the car is moving
    private boolean engineIsRunning; // is the engine running?
    private double speed; // the current speed of the car

    /**
     * Create a Car at rest
     */
    public Car()
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
     * @param speed the speed to set the car speed to
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
     * Turn this car in a given direction
     * @param dir the new direction of the car
     * @return true (assume that it always works)
     */
    public boolean turn(Direction dir)
    {
        this.dir = dir;
        return true;
    }

    /**
     * Describe the state of this car
     * @return the string that describes the car
     */
    public String toString()
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");

        String description;
        description = "Car status\n";
        description += "Engine: " + ((this.engineIsRunning)?"On":"Off") + "\n";
        description += "Speed: " + twoDigits.format(this.speed) + "\n";
        description += "Direction: " + this.dir.toString();

        return description;
    }
}





