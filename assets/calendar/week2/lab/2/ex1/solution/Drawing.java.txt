import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * A graphics panel for drawing polygons
 * 
 * @author CSC 143
 */
public class Drawing extends JPanel {

	// the frame of the panel
	private JFrame f;

	// The list of polygons in the panel
	private ArrayList<MyPolygon> polygonList;

	/**
	 * Creates the drawing (frame + panel)
	 */
	public Drawing() {
		// Create the frame
		f = new JFrame("Polygons");
		f.setSize(200, 375);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		// the panel is in the frame
		this.setSize(f.getContentPane().getSize());
		this.setBackground(Color.WHITE);
		f.getContentPane().add(this);
		// Initialize the list of polyogons
		polygonList = new ArrayList<MyPolygon>();
		// Show the frame
	}

	/**
	 * Adds a polygon to this panel
	 * 
	 * @param p
	 *            the polygon to add
	 */
	public void addPolygon(MyPolygon p) {
		polygonList.add(p);
	}

	/**
	 * Draws the polygons in the panel
	 * 
	 * @param g
	 *            the Graphics context to draw with
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MyPolygon p : polygonList) {
			p.draw(g);
		}
	}

	/**
	 * Draws several polygons in several windows
	 * 
	 * @param args
	 *            the list of the command line arguments
	 */
	public static void main(String[] args) {
		int n = 3;
		Drawing[] dArray = new Drawing[2 * n];

		Random rand = new Random();
		for (int k = 0; k < dArray.length; k++) {
			dArray[k] = new Drawing();
			Drawing d = dArray[k];
			for (int i = 0; i < 10; i++) {
				// Random array of points
				Point[] points = new Point[3 + rand.nextInt(5)];
				for (int j = 0; j < points.length; j++) {
					points[j] = new Point(rand.nextInt(d.getWidth()), rand
							.nextInt(d.getHeight()));
				}
				// Random color
				Color color = new Color(rand.nextInt(256), rand.nextInt(256),
						rand.nextInt(256));
				// Random fill
				boolean fill = rand.nextBoolean();
				d.addPolygon(new MyPolygon(points, color, fill));
			}
			d.repaint();
			// Tile the windows
			d.f.setLocation((k % n) * d.f.getWidth(), (k / n)
							* d.f.getHeight());
		}
	}
}
