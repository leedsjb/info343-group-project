import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class UsingFiles {
	public static void main(String[] args) {
		// open the input stream (from the file of this program)
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader("./src/UsingFiles.java"));
			writer = new PrintWriter("reverseFile.txt");
			// String line;
			// while ((line = reader.readLine()) != null) {
			// System.out.println(line);
			// }
			// print the file in reverse order
			// use recursion
			reverseFile(reader, writer);
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open the file!");
		} catch (IOException e) {
			System.out.println("Problem reading the file");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Couldn't close the reader");
				}
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	private static void reverseFile(BufferedReader reader, PrintWriter writer)
			throws IOException {
		String line = reader.readLine();
		if (line != null) {
			reverseFile(reader, writer);
			writer.println(line);
		}
	}
}
