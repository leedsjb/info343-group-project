import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Event handling with an inner class: a click on a button changes the color of
 * the panel of a graphics window
 * 
 * @author CSC 143
 * 
 */
public class GraphicsWindow extends JFrame {

	private JPanel panel;

	private JButton button;

	private ButtonListener listener;

	/**
	 * An inner class to handle the button click
	 */
	public class ButtonListener implements ActionListener {
		private Random rand = new Random();

		/**
		 * Changes the color of the panel in the enclosing instance
		 */
		public void actionPerformed(ActionEvent e) {
			// Paint the background of the panel with a random color
			Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand
					.nextInt(256));
			panel.setBackground(color);
			panel.repaint();
			// Note on syntax (as a side piece of information)
			// this refers to the ButtonListener instance
			// GraphicsWindow.this refers to the GraphicsWindow enclosing
			// instance
		}
	}

	/**
	 * Creates the graphics window
	 */
	public GraphicsWindow() {
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		button = new JButton("Change color");
		listener = new ButtonListener(); // instantiates the inner class.
		// listener has access to the panel
		button.addActionListener(listener);
		Container cp = getContentPane();
		cp.add(panel, BorderLayout.CENTER);
		cp.add(button, BorderLayout.SOUTH);
		setVisible(true);
	}

	/**
	 * Starts the application
	 * 
	 * @param args
	 *            the String array of the command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Start the application
		new GraphicsWindow();
	}

}
