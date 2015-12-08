import java.text.DecimalFormat; // for formatting

/**
 * A class to describe a direction
 */

public class Direction {

    // The angle of the direction (between 0 and 360)
    // 0=east, 90=north, 180=west, 270=south
    private double directionAngle;

    // A set of constant directions (EAST, NORTH, WEST, and SOUTH)
    /** East Direction */
    public static final Direction EAST = new Direction(0);
    /** North Direction */
    public static final Direction NORTH = new Direction(90);
    /** West Direction */
    public static final Direction WEST = new Direction(180);
    /** South Direction */
    public static final Direction SOUTH = new Direction(270);

    /**
     * The default direction is east
     */
    public Direction()
    {
        this(0);
    }

    /**
     * Create a Direction at a given angle (set between 0 and 360)
     * @param the angle of the Direction (as measured counterclockwise from East)
     */
    public Direction(double angle)
    {
        // set the angle between 0 and 360
        directionAngle = angle%360;
    }

    /**
     * @return the angle of the Direction as a String
     */
    public String toString()
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        return twoDigits.format(directionAngle) + " degrees counted counterclockwise from east";
    }
}