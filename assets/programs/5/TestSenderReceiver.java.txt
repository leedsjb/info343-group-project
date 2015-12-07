import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Places a sender, a buffer and a receiver in JFrame. Triggers the transfer of
 * characters via a button
 */

public class TestSenderReceiver {
	public static void main(String[] args) {
		// Windows Look and feel
		try {
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			System.out.println("Could not set the look and feel");
		}
		// Create a Buffer b, a Sender s, and a Receiver r
		// b can store up to 4 characters.
		Buffer b = new Buffer(4);
		// r sends "123456789" to b
		// After sending one character, it sleeps for 400 ms
		// Declare it final so that the inner class (for the button)
		// can access it
		final Sender s = new Sender("123456789", b, 400);
		// s receives from b. After receiving a character,
		// it sleeps for 800 ms
		// Declare it final as well
		final Receiver r = new Receiver(b, 800);

		// Graphics window
		JFrame frame = new JFrame("Testing threads");
		JPanel panel = new JPanel();
		JButton button = new JButton("Transfer");

		// Put the elements in a grid of 1 row by 3 columns
		panel.setLayout(new GridLayout(1, 3, 5, 5)); // 5 pixels between
		// rows, 5 pixels
		// between columns
		panel.add(s); // sender on the left
		panel.add(b); // buffer in the middle
		panel.add(r); // receiver on the right

		// Put everything in the frame and display it
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		// Button at the bottom of the frame
		JPanel southPanel = new JPanel();
		southPanel.add(button);
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
		frame.setSize(500, 300);
		frame.setVisible(true);

		// Start the transfer when the user clicks on the command button
		// button.addActionListener...
		// Use an anonymous class
		// new ActionListener(){ ...
		// implement public void actionPerformed(ActionEvent e)
		// Activate the Sender and Receiver only once
		button.addActionListener(new ActionListener() {
			boolean run;

			public void actionPerformed(ActionEvent e) {
				if (!run) {
					s.start();
					r.start();
					run = true;
				}
			}
		});

		// Terminate the application properly
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
