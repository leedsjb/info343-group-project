import java.awt.Color;
import java.util.ArrayList;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;

/**
 * A planet in the solar system
 * 
 * @author CSC 143
 */

public class Planet implements AstronomicalObject {

	// angular position of the planet (in radians)
	private double angle;

	// radius of the orbit (in meters)
	private double radius;

	// the sun
	private Sun sun;

	// diameter of the planet (in meters)
	private double planetDiameter;

	// the moons
	private ArrayList<AstronomicalObject> moons = new ArrayList<AstronomicalObject>();

	// period of the planet (in sec)
	private double period;

	// mass of the planet (in kg)
	private double mass;

	/**
	 * Creates a planet with the given data
	 * 
	 * @param sun
	 *            the sun at the center of the orbit
	 * @param radius
	 *            the radius of the orbit
	 * @param d
	 *            the diameter of the planet
	 * @param mass
	 *            the mass of the planet
	 */
	public Planet(Sun sun, double radius, double d, double mass) {
		this.sun = sun;
		this.radius = radius;
		this.planetDiameter = d;
		this.mass = mass;

		// Length of the year
		period = 2 * Math.PI
				* Math.sqrt(Math.pow(radius, 3) / 6.67E-11 / sun.getMass());
		// this object orbits around the sun
		sun.addOrbitingObject(this);
	}

	/**
	 * Gets the mass of this planet
	 * 
	 * @return the mass of this planet (in kg)
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * Gets the angular position of the astronomical object
	 * 
	 * @return the angular position of the orbiting astronomical object (in
	 *         radians)
	 */
	public double getAngularPosition() {
		return angle;
	}

	/**
	 * Gets the radius of the orbit (in meters)
	 * 
	 * @return the radius of the orbit in meters
	 */
	public double getOrbitalRadius() {
		return radius;
	}

	/**
	 * Gets the size of the object (generally the diameter)
	 * 
	 * @return the size of the object (in meters)
	 */
	public double getSize() {
		return planetDiameter;
	}

	/**
	 * Gets the object at the center of the orbit
	 * 
	 * @return the astronomical object at the center of the orbit
	 */
	public AstronomicalObject getOrbitCenter() {
		return sun;
	}

	/**
	 * Updates the position of the astronomical object as it moves during a
	 * given time interval
	 * 
	 * @param dt
	 *            the time interval
	 */
	public void move(double dt) {
		angle += dt / period * 2 * Math.PI;
		while (angle >= 2 * Math.PI) {
			angle -= 2 * Math.PI;
		}
	}

	/**
	 * Gets the arraylist of the objects that orbit around this object
	 * 
	 * @return the arraylist of astronomical objects that orbit around this
	 *         astronomical object
	 */
	public ArrayList<AstronomicalObject> getOrbitingObjects() {
		return moons;
	}

	/**
	 * Adds an astronomical object that orbits around this astronomical object
	 * 
	 * @param astrObject
	 *            the astronomical object to add
	 * @return true if the object could be added and false otherwise
	 */
	public boolean addOrbitingObject(AstronomicalObject astrObject) {
		return moons.add(astrObject);
	}

	/**
	 * Removes an astronomical object that orbits around this astronomical
	 * object
	 * 
	 * @param astrObject
	 *            the astronomical object to remove
	 * @return true if the object could be removed and false otherwise
	 */
	public boolean removeOrbitingObject(AstronomicalObject astrObject) {
		return moons.remove(astrObject);
	}

	/**
	 * Draws this object in a graphics window
	 * 
	 * @param window
	 *            the graphics window where to draw
	 * @param scale
	 *            the scale to use to draw the object
	 */
	public void draw(GWindow window, double scale) {
		int centerX = (int) (sun.getX() * scale + window.getWindowWidth() / 2);
		int centerY = (int) (-sun.getY() * scale + window.getWindowHeight() / 2);
		int x = (int) (getX() * scale + window.getWindowWidth() / 2);
		int y = (int) (-getY() * scale + window.getWindowHeight() / 2);
		int r = (int) (radius * scale);
		// Draw a circle for the orbit
		window.add(new Oval(centerX - r, centerY - r, 2 * r, 2 * r,
				Color.black, false));
		// Draw another circle for the planet
		int size = (int) (this.planetDiameter * scale) / 2;
		if (size < 4) {
			size = 4;
		}
		window.add(new Oval(x - size / 2, y - size / 2, size, size, Color.blue,
				true));
	}

	/**
	 * Gets the x position of the object
	 * 
	 * @return the x position in meters of the object relative to the center of
	 *         the orbit
	 */
	public double getX() {
		return radius * Math.cos(angle) + sun.getX();
	}

	/**
	 * Gets the y position of the object
	 * 
	 * @return the y position in meters of the object relative to the center of
	 *         the orbit
	 */
	public double getY() {
		return radius * Math.sin(angle) + sun.getY();
	}
}