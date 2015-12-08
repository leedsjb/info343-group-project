import uwcse.graphics.GWindow;
import java.util.ArrayList;

/**
 * An interface to describe what an astronomical object such as a star,
 * a planet or a moon should do in our universe
 * An astronomical object orbits around some other astronomical object
 * @author CSC 143
 */
public interface AstronomicalObject {

    /**
     * Gets the angular position of the astronomical object
     * @return the angular position of the orbiting astronomical object (in
     * radians)
     */
    public double getAngularPosition();

    /**
     * Gets the radius of the orbit (in meters)
     * @return the radius of the orbit in meters
     */
    public double getOrbitalRadius();

    /**
     * Gets the mass of the object (in kg)
     * @return the mass of the object in kilograms
     */
    public double getMass();


    /**
     * Gets the size of the object (generally the diameter)
     * @return the size of the object (in meters)
     */
    public double getSize();

    /**
     * Gets the object at the center of the orbit
     * @return the astronomical object at the center of the orbit
     */
    public AstronomicalObject getOrbitCenter();

    /**
     * Updates the position of the astronomical object as it moves during
     * a given time interval
     * @param dt the time interval
     */
    public void move(double dt);

    /**
     * Gets the arraylist of the objects that orbit around this object
     * @return the arraylist of astronomical objects that orbit around this
     * astronomical object
     */
    public ArrayList getOrbitingObjects();

    /**
     * Adds an astronomical object that orbits around this astronomical object
     * @param astrObject the astronomical object to add
     * @return true if the object could be added and false otherwise
     */
    public boolean addOrbitingObject(AstronomicalObject astrObject);

    /**
     * Removes an astronomical object that orbits around this astronomical
     * object
     * @param astrObject the astronomical object to remove
     * @return true if the object could be removed and false otherwise
     */
    public boolean removeOrbitingObject(AstronomicalObject astrObject);

    /**
     * Draws this object in a graphics window
     * @param window the graphics window where to draw
     * @param scale the scale to use to draw the object
     */
    public void draw(GWindow window, double scale);

    /**
     * Gets the x position of the object
     * @return the x position in meters of the object relative
     * to the center of the orbit
     */
    public double getX();

    /**
     * Gets the y position of the object
     * @return the y position in meters of the object relative to the center
     * of the orbit
     */
    public double getY();
}