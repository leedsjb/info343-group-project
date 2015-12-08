import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionExercises {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = scan.nextLine();
		File file = new File(fileName);

		// Deal with the exceptions in main
		try {
			int count = countLines(file);
			System.out.println("Number of lines = " + count);
		} catch (FileNotFoundException e) {
			System.out.println("The file could be not be found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading the file.");
			e.printStackTrace();
		} finally {
			System.out.println("done no matter what");
		}

		// The method returns -1 if there is a problem
		int count = countLines2(file);
		System.out.println("Number of lines = " + count);

		// The method throws a LineCountException if there
		// is a problem
		count = countLines5(file);
		System.out.println("Number of lines = " + count);

		// The method terminates the application if there
		// is a problem
		// last one since it terminates the application
		count = countLines3(file);
		System.out.println("Number of lines = " + count);

	}

	/**
	 * Returns the number of lines in the given text file
	 * 
	 * @param file
	 *            the given text file
	 * @throws IOException
	 *             if the file could not be read
	 * @throws FileNotFoundException
	 *             if the file could not be found
	 */
	public static int countLines(File file) throws IOException,
			FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader(file));

		int count = 0;
		String line;
		// print and count the lines in the file
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			count++;
		}
		in.close();
		return count;
	}

	/**
	 * Returns the number of lines in the given text file, or -1 if there is a
	 * problem
	 * 
	 * @param file
	 *            the given text file
	 */
	public static int countLines2(File file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			int count = 0;
			String line;
			// print and count the lines in the file
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				count++;
			}
			in.close();
			return count;
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e) {
			return -1;
		}
	}

	/**
	 * Returns the number of lines in the given text file, or prints an error
	 * message and terminates the program if there is a problem
	 * 
	 * @param file
	 *            the given text file
	 */
	public static int countLines3(File file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			int count = 0;
			String line;
			// print and count the lines in the file
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				count++;
			}
			in.close();
			return count;
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(-1);
			return -1; // never get here but the compiler
			// can't tell
		} catch (IOException e) {
			System.out.println("Problem reading the file!");
			System.exit(-1);
			return -1; // never get here but the compiler
			// can't tell
		}
	}

	// countLines4 is countLines3 with some System.out.println
	// in the catch clauses.

	/**
	 * Returns the number of lines in the given text file, or catches the
	 * exception if there is a problem and throws another exception
	 * 
	 * @param file
	 *            the given text file
	 */
	public static int countLines5(File file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			int count = 0;
			String line;
			// print and count the lines in the file
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				count++;
			}
			in.close();
			return count;
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			throw new LineCountException("File not found!");
		} catch (IOException e) {
			System.out.println("Problem reading the file!");
			throw new LineCountException("Couldn't read the file");
		}
	}

}

// our own unchecked exception
class LineCountException extends RuntimeException {
	public LineCountException(String s) {
		super(s);
	}

	public LineCountException() {

	}
}
