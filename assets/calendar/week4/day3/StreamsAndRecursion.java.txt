import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StreamsAndRecursion {
	// write a method that takes a text file and prints
	// it in reverse order. Use recursion in your solution.

	// if the file contained
	// line 1
	// line 2
	// line 3
	// the method would print
	// line 3
	// line 2
	// line 1

	public static void printReverse(Scanner scan) {
		// base scan : end of file
		// nothing to do
		if (scan.hasNextLine()) {
			String line = scan.nextLine();
			printReverse(scan);
			System.out.println(line);
		}
	}

	public static void main(String[] args) throws IOException {
		printReverse(new Scanner(new File("./src/StreamsAndRecursion.java")));
	}

}
