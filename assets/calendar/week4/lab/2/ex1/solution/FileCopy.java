import java.io.*;

/**
 * A simple file copy utility
 */
public class FileCopy {

	/**
	 * Copies a source file to a destination file. The file names are given on
	 * the command line. The source file name is the first argument. The
	 * destination file name is the second argument.
	 * 
	 * @param args
	 *            the array of the command line arguments
	 */
	public static void main(String[] args) throws IOException {

		// quit if we don't have exactly two command-line arguments
		if (args.length != 2) {
			System.err.println("FileCopy requires two filenames as arguments");
			return;
		}

		// Open an input stream from the input file (FileReader)
		FileReader inFile;
		try {
			inFile = new FileReader(args[0]);
		} catch (IOException e) {
			System.err.println("exception opening file - exception object: ");
			System.err.println(e);
			return;
		}
		BufferedReader in = new BufferedReader(inFile);

		// Open an output stream to the output file (use FileWriter and PrintWriter)
		FileWriter outFile;
		try {
			outFile = new FileWriter(args[1]);
		} catch (IOException e) {
			System.err
					.println("exception creating output file - exception object:");
			System.err.println(e);
			return;
		}
		PrintWriter out = new PrintWriter(outFile);

		// copy input file to output one line at a time,
		// and print lines on System.out also
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			out.println(line);
		}

		// close both streams
		in.close();
		out.close();
	}
}
