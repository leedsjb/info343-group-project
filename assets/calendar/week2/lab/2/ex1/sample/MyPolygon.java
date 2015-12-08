import java.awt.*;

/**
 * A class to represent a polygon
 * 
 * @author CSC 143
 */

public class MyPolygon implements Cloneable {

	// Polygon features
	private Point[] points;

	private Color color;

	private boolean fill;

	/**
	 * Creates an empty non filled polygon with a default color
	 */
	public MyPolygon() {
	}

	/**
	 * Creates a polygon
	 * 
	 * @param points
	 *            the array of points defining the polygon
	 * @param color
	 *            the color of the polygon
	 * @param fill
	 *            is the polygon filled?
	 */
	public MyPolygon(Point[] points, Color color, boolean fill) {
		// Make sure that the instance fields are deep copies of the
		// parameters

		// Create the array by cloning (but this is a shallow copy)

		// Make it a deep copy
		// Point has a clone method


		// Copy the color (the deep copy is not necessary, since a color is
		// immutable)

		// Copy the fill boolean

	}

	/**
	 * Adds a point to this polygon. The added point is connected to the last
	 * point of the polygon.
	 * 
	 * @Point p the point to add
	 */
	public void addPoint(Point p) {
		// Make the points array bigger by one
		// (note points is never null: see default constructor)

		// Copy the current points

		// Add the extra point (make a copy of the extra point)
	}

	/**
	 * Draws this polygon
	 * 
	 * @param g
	 *            the Graphics object to draw with
	 */
	public void draw(Graphics g) {
		// use drawPolygon or fillPolygon (check the documentation)
	}

	/**
	 * Sets the color of this polygon
	 * 
	 * @param color
	 *            the new color of this polygon
	 */
	public void setColor(Color color) {
	}

	/**
	 * Set the fill status of this polygon
	 * 
	 * @param fill
	 *            the new fill status of this polygon
	 */
	public void setFill(boolean fill) {
	}

	/**
	 * Move this polygon
	 * 
	 * @param dx
	 *            the displacement along the x axis
	 * @param dy
	 *            the displacement along the y axis
	 */
	public void moveBy(int dx, int dy) {
	}

	/**
	 * Returns a string representation of this polygon
	 * 
	 * @return a string representation of this polygon
	 */
	public String toString() {
	}

	/**
	 * Clones this polygon
	 * 
	 * @return a polygon which is a deep copy of this polygon
	 */
	public Object clone() {
		// Use the clone method from Object (we get a shallow copy)
		
		// Make a deep copy

	}

	/**
	 * Is this polygon equal to that object
	 * 
	 * @param o
	 *            the object to compare to
	 */
	public boolean equals(Object o) {
	}
}
