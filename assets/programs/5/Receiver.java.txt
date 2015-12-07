import javax.swing.*;
import java.awt.*;

/**
 * A Receiver is a JPanel with a JTextField that gets characters from a buffer
 */

public class Receiver extends JPanel implements Runnable {

	// to display the String which is received
	private JTextField textField = new JTextField(10);

	private Buffer buffer; // Buffer that sends the String

	private char[] text; // to store the String

	// The Receiver works independently (as a Thread)
	private Thread t;

	private int sleepTime;

	public Receiver(Buffer b, int time) {
		// initialize b and sleepTime
		this.buffer = b;
		this.sleepTime = time;

		// no text initially
		this.text = new char[0];

		// Initialize t (it will execute the run method when started)
		this.t = new Thread(this, "Receiver");

		// display the text in a JTextField
		this.textField.setEditable(false);
		this.textField.setFont(new Font("Courier", Font.BOLD, 20));
		this.add(textField);
	}

	// Begin to receive
	public void start() {
		// Start the receiving thread
		this.t.start();
	}

	public void run() {
		// infinite loop
		while (true) {
			// Increase the text by one character
			char[] temp = new char[this.text.length + 1];

			// copy text in temp
			System.arraycopy(this.text, 0, temp, 0, this.text.length);

			try {
				// Get the new character from the buffer
				temp[this.text.length] = this.buffer.remove();
				// Display the new text
				this.text = temp;
				this.textField.setText(this.toString());
				// take a break
				Thread.sleep(this.sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String toString() {
		// Write the text content as a string
		return new String(this.text);
	}

}
