import javax.swing.*;
import java.awt.*;

/**
 * A holding area for characters received from a Receiver
 */
public class Buffer extends JPanel {

	// to store the characters received from the Sender
	private char[] chars;

	// current number of characters in the buffer
	private int number;

	// for the display of the buffer (each character in one JTextField)
	private JTextField[] display;

	// Construct a buffer of size n
	public Buffer(int n) {
		// chars is of size n
		this.chars = new char[n];

		// Initially the buffer is empty
		// initialize chars with blanks (for the display)
		for (int i = 0; i < this.chars.length; i++)
			chars[i] = ' ';

		// Each character is displayed in one textfield
		this.display = new JTextField[n];
		this.setLayout(new GridLayout(this.display.length, 1, 5, 5));
		for (int i = 0; i < this.display.length; i++) {
			this.display[i] = new JTextField(2);
			this.display[i].setFont(new Font("Courier", Font.BOLD, 20));
			this.display[i].setEditable(false);
			this.display[i].setHorizontalAlignment(JTextField.CENTER);
			JPanel myPanel = new JPanel();
			myPanel.add(display[i]);
			this.add(myPanel);
		}
		this.setText();
	}

	public boolean isEmpty() {
		// Is the buffer empty?
		return this.number == 0;
	}

	public boolean isFull() {
		// Is the buffer full?
		return this.number == this.chars.length;
	}

	// to add, we must have a lock on the buffer
	public synchronized void add(char c) throws InterruptedException {
		// if the buffer is full, we can't add. We must wait.
		while (this.isFull())
			this.wait();

		// Add the character at the beginning of the array
		for (int i = this.number - 1; i >= 0; i--)
			this.chars[i + 1] = this.chars[i];

		this.chars[0] = c;
		this.number++;

		// Update the display (call setText)
		this.setText();

		// the buffer is no longer empty
		// say so to any thread that is waiting
		// call notifyAll();
		this.notifyAll();
	}

	// to remove, we must have a lock on the buffer
	public synchronized char remove() throws InterruptedException {
		// if the buffer is empty, we can't remove a character. We must wait.
		while (this.isEmpty())
			this.wait();

		// Remove the character at the beginning of the array
		// For the display make it a blank.
		char temp = this.chars[number - 1];
		this.chars[number - 1] = ' ';
		this.number--;
		this.setText();

		// the buffer is no longer full:
		// notify any thread that is waiting
		this.notifyAll();

		// return the character that has been removed
		return temp;
	}

	private void setText() {
		// Display the buffer content
		for (int i = 0; i < this.chars.length; i++)
			this.display[i].setText(new String(new char[] { this.chars[i] }));
	}

}
