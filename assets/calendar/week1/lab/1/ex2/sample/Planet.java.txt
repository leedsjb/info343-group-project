import uwcse.graphics.*;
import java.util.*;
import java.awt.Color;

/**
 * A planet in the solar system
 * @author CSC 143
 */

public class Planet implements AstronomicalObject{

    // angular position of the planet (in radians)
    private double angle;
    // radius of the orbit (in meters)
    private double radius;
    // the sun
    private Sun sun;
    // diameter of the planet (in meters)
    private double planetDiameter;
    // the moons
    private ArrayList moons = new ArrayList();
    // period of the planet (in sec)
    private double period;
    // mass of the planet (in kg)
    private double mass;


    /**
     * Creates a planet with the given data
     * @param sun the sun at the center of the orbit
     * @param radius the radius of the orbit
     * @param d the diameter of the planet
     * @param mass the mass of the planet
     */
    public Planet(Sun sun, double radius, double d, double mass) {

        // Length of the year

        // this object orbits around the sun
    }


    /**
     * Gets the mass of this planet
     * @return the mass of this planet (in kg)
     */
    public double getMass() {
    }

    /**
     * Gets the angular position of the astronomical object
     * @return the angular position of the orbiting astronomical object (in
     * radians)
     */
    public double getAngularPosition() {
    }

    /**
     * Gets the radius of the orbit (in meters)
     * @return the radius of the orbit in meters
     */
    public double getOrbitalRadius() {
    }

    /**
     * Gets the size of the object (generally the diameter)
     * @return the size of the object (in meters)
     */
    public double getSize() {
    }

    /**
     * Gets the object at the center of the orbit
     * @return the astronomical object at the center of the orbit
     */
    public AstronomicalObject getOrbitCenter() {
    }

    /**
     * Updates the position of the astronomical object as it moves during
     * a given time interval
     * @param dt the time interval
     */
    public void move(double dt) {
    }

    /**
     * Gets the arraylist of the objects that orbit around this object
     * @return the arraylist of astronomical objects that orbit around this
     * astronomical object
     */
    public ArrayList getOrbitingObjects() {
    }

    /**
     * Adds an astronomical object that orbits around this astronomical object
     * @param astrObject the astronomical object to add
     * @return true if the object could be added and false otherwise
     */
    public boolean addOrbitingObject(AstronomicalObject astrObject) {
    }

    /**
     * Removes an astronomical object that orbits around this astronomical
     * object
     * @param astrObject the astronomical object to remove
     * @return true if the object could be removed and false otherwise
     */
    public boolean removeOrbitingObject(AstronomicalObject astrObject) {
    }

    /**
     * Draws this object in a graphics window
     * @param window the graphics window where to draw
     * @param scale the scale to use to draw the object
     */
    public void draw(GWindow window, double scale) {
    }

    /**
     * Gets the x position of the object
     * @return the x position in meters of the object relative
     * to the center of the orbit
     */
    public double getX() {
    }

    /**
     * Gets the y position of the object
     * @return the y position in meters of the object relative to the center
     * of the orbit
     */
    public double getY() {
    }
}