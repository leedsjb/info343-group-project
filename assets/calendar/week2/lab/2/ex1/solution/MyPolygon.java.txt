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
		this.points = new Point[0];
		color = Color.BLACK;
		fill = false;
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
		this.points = (Point[]) points.clone();
		// Make it a deep copy
		// Point has a clone method
		for (int i = 0; i < this.points.length; i++) {
			this.points[i] = (Point) points[i].clone();
		}

		// Copy the color (the deep copy is not necessary, since a color is
		// immutable)
		this.color = color;

		// Copy the fill boolean
		this.fill = fill;

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
		Point[] copy = new Point[points.length + 1];
		// Copy the current points
		System.arraycopy(this.points, 0, copy, 0, this.points.length);
		// Add the extra point (make a copy the extra point)
		this.points = copy;
		this.points[this.points.length - 1] = (Point) p.clone();
	}

	/**
	 * Draws this polygon
	 * 
	 * @param g
	 *            the Graphics object to draw with
	 */
	public void draw(Graphics g) {
		// use drawPolygon or fillPolygon (check the documentation)
		int[] x = new int[points.length];
		int[] y = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			x[i] = points[i].x;
			y[i] = points[i].y;
		}

		g.setColor(color);
		if (fill) {
			g.fillPolygon(x, y, points.length);
		} else {
			g.drawPolygon(x, y, points.length);
		}
	}

	/**
	 * Sets the color of this polygon
	 * 
	 * @param color
	 *            the new color of this polygon
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Set the fill status of this polygon
	 * 
	 * @param fill
	 *            the new fill status of this polygon
	 */
	public void setFill(boolean fill) {
		this.fill = fill;
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
		for (Point p : points) {
			p.x += dx;
			p.y += dy;
		}
	}

	/**
	 * Returns a string representation of this polygon
	 * 
	 * @return a string representation of this polygon
	 */
	public String toString() {
		String s = "MyPolyon[fill = " + fill + "  color = " + color
				+ "  points = ";
		for (Point p : points) {
			s += p + " ";
		}
		s += "]";
		return s;
	}

	/**
	 * Clones this polygon
	 * 
	 * @return a polygon which is a deep copy of this polygon
	 */
	public Object clone() {
		// Use the clone method from Object (we get a shallow copy)
		MyPolygon copy;
		try {
			copy = (MyPolygon) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}

		// Make a deep copy
		copy.points = (Point[]) points.clone();
		for (int i = 0; i < points.length; i ++) {
			copy.points[i] = (Point) points[i].clone();
		}

		return copy;
	}

	/**
	 * Is this polygon equal to that object?
	 * 
	 * @param o
	 *            the object to compare to
	 */
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			MyPolygon p = (MyPolygon) o;
			if (p.fill == fill && p.color.equals(color)
					&& p.points.length == points.length) {
				boolean eq = true;
				for (int i = 0; eq && i < points.length; i++) {
					eq = eq && points[i].equals(p.points[i]);
				}
				return eq;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
