/**
 * An interface to describe what a Driveable can do. But the interface
 * doesn't say how it is done.
 */

public interface Driveable {

    // Note: all methods in an interface are implicitly public (though they
    // might not be if the interface is not declared public itself)
    // In terms of style it is better to write the keyword public

    /**
     *  start the engine
     *  @return = the engine is running
     */
    public boolean start();

    /**
     *  Set the speed to a given speed (if valid)
     *  @param speed the new cruising speed
     *  @return the new speed.
     */
    public double cruise(double speed);

    /**
     * turn in a given direction
     * @param dir the direction to turn
     * @return = the turn is successful
     */
    public boolean turn(Direction dir);

    /**
     * stop the engine
     * @return = the engine is stopped
     */
    public boolean stop();
}