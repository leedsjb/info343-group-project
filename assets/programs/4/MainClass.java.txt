import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * An illustration of event handling
 * 
 * @author CSC 143
 * 
 */
public class MainClass {

	/**
	 * Creates a graphics window that contains a panel and a button. When the
	 * button is clicked, the panel changes of color.
	 * 
	 * @param args
	 *            the String array of the command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Frame
		JFrame frame = new JFrame("Swing with events");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		// inner panel
		// final is required only if the program uses an anonymous inner class
		final JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		// Button to change the color of the inner panel
		JButton button = new JButton("Change color");

		// Handle the button click:
		// Approach 1: Use another class
//		 button.addActionListener(new ButtonListener(panel));

		// Approach 2: Use an anonymous inner class
		button.addActionListener(new ActionListener() {
			private Random rand = new Random();

			public void actionPerformed(ActionEvent e) {
				// Paint the background of the panel with a random color
				Color color = new Color(rand.nextInt(256), rand.nextInt(256),
						rand.nextInt(256));
				panel.setBackground(color);
				panel.repaint();
			}
		});


		Container cp = frame.getContentPane();
		cp.add(panel, BorderLayout.CENTER);
		cp.add(button, BorderLayout.SOUTH);
		
		// Show the window
		frame.setVisible(true);
		
		// Addition: how to size the inner panel exactly to (400, 300)
		Insets insets = frame.getInsets();
		frame.setSize(insets.left + insets.right + 400, insets.top
				+ insets.bottom + button.getHeight() + 300);
		// Check it (by clicking with the mouse)
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
			}
		});
		
		frame.validate();
	}
}
