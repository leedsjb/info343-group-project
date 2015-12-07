/**
 * A simple model of a button listener that changes
 * the color of a panel when notified
 * @author CSC 143
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.util.Random;
import java.awt.Color;

public class ButtonListener implements ActionListener {

	// the panel to modify
	private JPanel panel;

	// to generate the random color
	private Random rand;

	/**
	 * Creates a ButtonListener
	 * 
	 * @param thePanel
	 *            the JPanel whose background color is changed by this listener.
	 */
	public ButtonListener(JPanel thePanel) {
		panel = thePanel;
		rand = new Random();
	}

	/**
	 * Changes the background color of the panel
	 * 
	 * @param e
	 *            the description of the Button click event
	 */
	public void actionPerformed(ActionEvent e) {
		// Paint the background of the panel with a random color
		Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand
				.nextInt(256));
		panel.setBackground(color);
		panel.repaint();
	}

}