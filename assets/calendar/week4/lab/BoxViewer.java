import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class BoxViewer extends JPanel {

	// The box viewed by this viewer
	private Box box;

	/**
	 * Creates a box viewer within a frame
	 */
	public BoxViewer() {
		setBackground(Color.WHITE);
		// Create a frame for this panel
		JFrame frame = new JFrame("Box viewer");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		// The box (-2 so all of it is visible for the outer box)
		box = new Box(this.getWidth() / 2, this.getHeight() / 2, this.getHeight() - 2,
				this.getWidth() - 2, Color.RED);

		// A click on the panel adds an inner box to the box
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				box.addInnerBox();
				repaint();
			}
		});
	}

	/**
	 * Paints the contents of this viewer
	 * 
	 * @param g
	 *            the graphics context to use.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (box != null) {
			box.draw(g);
		}
	}

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            the list of the command line parameters.
	 */
	public static void main(String[] args) {
		new BoxViewer();
	}
}
