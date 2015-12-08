import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Reads the contents of a text file and writes in reverse order to another
 * file. Use recursion
 * 
 * @author CSC 143
 *
 */
public class FileExample {
	public static void main(String[] args) {
		// open a stream to the input and output files
		Reader input = null;
		Writer output = null;
		try {
			input = new FileReader("./src/FileExample.java");
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the input file!");
			return;
		}

		try {
			// the output file is automatically created
			output = new FileWriter("copy.txt");
		} catch (IOException e) {
			System.out.println("Could not create the output file!");
			closeStreams(input, output);
			return;
		}

		// Make the copy (use recursion)
		try {
			reverseFile(input, output);
		} catch (IOException e) {
			System.out.println("Could not make the copy!");
			closeStreams(input, output);
			return;
		}

		// close the streams
		closeStreams(input, output);
	}

	public static void reverseFile(Reader input, Writer output)
			throws IOException {
		int data = input.read();
		// base case data is -1 (done with the input file)
		if (data != -1) {
			reverseFile(input, output);
			output.write(data);
		}

	}

	public static void closeStreams(Reader input, Writer output) {
		try {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		} catch (IOException e) {
			System.out.println("Could not close the input and output streams.");
		}

	}
}
