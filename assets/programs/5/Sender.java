import javax.swing.*;
import java.awt.*;

/**
 * A Sender is a JPanel with a JTextField that sends characters to a buffer
 */

public class Sender extends JPanel implements Runnable {

	// to display the text which is sent
	private JTextField textField = new JTextField(10); // 10 columns

	private Buffer buffer; // Buffer that receives the text sent

	private char[] text; // to store the text

	// The Sender works independently (as a Thread)
	Thread t;

	int sleepTime;

	// Constructor
	public Sender(String s, Buffer b, int time) {
		// initialize b and sleepTime
		buffer = b;
		sleepTime = time;

		// Copy s in text
		text = new char[s.length()];
		for (int i = 0; i < s.length(); i++)
			text[i] = s.charAt(i);

		// Display the text in a JTextField
		textField.setEditable(false);
		textField.setFont(new Font("Courier", Font.BOLD, 20));
		textField.setText(s);
		add(textField);

		// Initialize t (t will execute the run method when started)
		t = new Thread(this, "Sender");
	}

	// Begin to send
	public void start() {
		// Start t
		t.start();
	}

	public void run() {
		// Transfer the text one character at a time
		// as long as there is text to send
		while (text.length != 0) {

			try {
				// one character is sent to the buffer
				// add requires a lock on the buffer
				// we might be interrupted while having the lock (need a try
				// block)
				buffer.add(text[0]);

				// update the text and the display
				char[] temp = new char[text.length - 1];
				for (int i = 0; i < text.length - 1; i++)
					temp[i] = text[i + 1];
				text = temp;
				textField.setText(this.toString());

				// take a break
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String toString() {
		// Write the text content as a String
		return new String(text);
	}

}