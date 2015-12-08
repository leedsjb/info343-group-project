import javax.swing.*;
import java.io.*;

/**
 * Write your own Input class
 */

public class MyInput {
	/**
	 * Reads an int entered by the user in the terminal window If the input is
	 * invalid, the method asks for the input again
	 * 
	 * @param prompt
	 *            the prompt message displayed to the user
	 */
	public int readInt(String prompt) {
		// Create a stream able to read strings from the terminal
		// (System.in can't: it just reads bytes)
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

		// Display the prompt
		if (prompt != null) {
			System.out.print(prompt);
		}

		// Read the input from the user (as a String)
		String s = null;
		try {
			s = r.readLine();
		} catch (IOException ioe) {
			System.out.println("Input failure");
			// Terminate
			throw new Error("Problem reading from the console window");
		}

		// Parse the string
		try {
			// return the int found in the String
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid entry");
		}

		// try again
		return readInt(prompt);
	}

	/**
	 * Reads an int entered by the user in a dialog box If the input is invalid,
	 * the method asks for the input again.
	 * 
	 * @param prompt
	 *            the prompt message displayed to the user
	 */
	public int readIntDialog(String prompt) {
		// Use a dialog box
		String s = JOptionPane.showInputDialog(null, prompt, "Input",
				JOptionPane.QUESTION_MESSAGE);

		// Parse the string
		try {
			// return the int found in the String
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			if (!prompt.endsWith("\nInvalid entry"))
				prompt += "\nInvalid entry";
		}

		// try again
		return readIntDialog(prompt);
	}
}
