import java.awt.Color;
import java.util.ArrayList;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;

/**
 * A moon in the solar system
 * 
 * @author CSC 143
 */

public class Moon implements AstronomicalObject {

	// angular position of the planet (in radians)
	private double angle;

	// radius of the orbit
	private double radius;

	// the planet at the center of the orbit
	private Planet planet;

	// diameter of the moon
	private double moonDiameter;

	// period of the moon (in sec)
	private double period;

	// the mass of the moon (in kg)
	private double mass;

	/**
	 * Creates a moon with the given data
	 * 
	 * @param planet
	 *            the planet at the center of the orbit
	 * @param radius
	 *            the radius of the orbit
	 * @param d
	 *            the diameter of the moon
	 * @param mass
	 *            the mass of the moon
	 */
	public Moon(Planet planet, double radius, double d, double mass) {
		this.planet = planet;
		this.radius = radius;
		this.moonDiameter = d;
		this.mass = mass;

		// Length of one revolution
		period = 2 * Math.PI
				* Math.sqrt(Math.pow(radius, 3) / 6.67E-11 / planet.getMass());
		// this object orbits around the planet
		planet.addOrbitingObject(this);
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
	 * Gets the mass of the moon (in kg)
	 * 
	 * @return the mass of the moon in kilograms
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * Gets the size of the object (generally the diameter)
	 * 
	 * @return the size of the object (in meters)
	 */
	public double getSize() {
		return moonDiameter;
	}

	/**
	 * Gets the object at the center of the orbit
	 * 
	 * @return the astronomical object at the center of the orbit
	 */
	public AstronomicalObject getOrbitCenter() {
		return planet;
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
	 * @return null since we assume that there are no moons around a moon
	 */
	public ArrayList<AstronomicalObject> getOrbitingObjects() {
		return null;
	}

	/**
	 * Adds an astronomical object that orbits around this astronomical object
	 * 
	 * @param astrObject
	 *            the astronomical object to add
	 * @return true if the object could be added and false otherwise
	 */
	public boolean addOrbitingObject(AstronomicalObject astrObject) {
		throw new UnsupportedOperationException("Method is not implemented");
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
		throw new UnsupportedOperationException("Method is not implemented");
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
		int centerX = (int) (planet.getX() * scale + window.getWindowWidth() / 2);
		int centerY = (int) (-planet.getY() * scale + window.getWindowHeight() / 2);
		int x = (int) (getX() * scale + window.getWindowWidth() / 2);
		int y = (int) (-getY() * scale + window.getWindowHeight() / 2);
		int r = (int) (radius * scale);
		if (r < 10) {
			r = 10;
			x = centerX + (int) (r * Math.cos(angle));
			y = centerY + (int) (-r * Math.sin(angle));
		}
		// Draw a circle for the orbit
		window.add(new Oval(centerX - r, centerY - r, 2 * r, 2 * r,
				Color.black, false));
		// Draw another circle for the planet
		int size = (int) (this.moonDiameter * scale) / 2;
		if (size < 4) {
			size = 4;
		}
		window.add(new Oval(x - size / 2, y - size / 2, size, size, Color.red,
				true));
	}

	/**
	 * Gets the x position of the object
	 * 
	 * @return the x position in meters of the object relative to the center of
	 *         the orbit
	 */
	public double getX() {
		return radius * Math.cos(angle) + planet.getX();
	}

	/**
	 * Gets the y position of the object
	 * 
	 * @return the y position in meters of the object relative to the center of
	 *         the orbit
	 */
	public double getY() {
		return radius * Math.sin(angle) + planet.getY();
	}
}