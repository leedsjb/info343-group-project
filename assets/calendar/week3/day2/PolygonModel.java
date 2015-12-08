import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;

public class PolygonModel {
	// Coordinates and color of the polygon
	private int[] x = {};
	private int[] y = {};
	private Color color;

	// size of the area that displays the polygon
	private int width, height;

	// to generate random numbers
	private static Random rand = new Random();

	// the list of views for the model
	ArrayList<View> views = new ArrayList<View>();

	// updates all of the views connected to this model
	public void updateViews() {
		for (View view : views) {
			view.update(this);
		}
	}

	// Adds a new view to the model
	public void addView(View view) {
		views.add(view);
		view.update(this);
	}
	
	// Sets the size of the area where the polygon is displayed
	public void setArea(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// Creates a polygon give a drawing area
	public void createPolygon() {
		// Create a polygon
		int nPoints = rand.nextInt(10) + 10; // between 10 and 19 points
		x = new int[nPoints];
		y = new int[nPoints];
		for (int i = 0; i < nPoints; i++) {
			x[i] = rand.nextInt(width);
			y[i] = rand.nextInt(height);
		}
		color = new Color(rand.nextInt(), true);

		// new data -> update the views
		updateViews();
	}

	// Returns the polygon
	public Polygon getPolygon() {
		return new Polygon(x, y, x.length);
	}

	// Returns the color of the polygon
	public Color getColor() {
		return color;
	}
}
