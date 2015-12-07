import java.util.ArrayList;
import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import java.awt.Color;

/**
 * A sun is at the center of the solar system
 * @author CSC 143
 */

public class Sun implements AstronomicalObject {

    // the planets that orbit around the sun
    private ArrayList planets = new ArrayList();

    // the sun mass
    private double mass;

    /**
     * Creates a sun with the given mass
     * @param the mass of the sun
     */
    public Sun(double mass) {
    }

    /**
     * Gets the mass of this sun
     * @return the mass of this sun (in kg)
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
    public double getOrbitalRadius(){
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
        // Assume that the sun is at the center of the window
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