import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
	public static void main(String[] args) {

		// quit if we don't have exactly two command-line arguments
		if (args.length != 2) {
			args = new String[] { "iconjava.gif", "copy.gif" };
		}

		InputStream in;
		try {
			// Open an input stream from the input file (FileInputStream)
			in = new FileInputStream(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + args[0]);
			return;
		}

		OutputStream out;
		try {
			// Open an output stream to the output file (FileOutputStream)
			out = new FileOutputStream(args[1]);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + args[1]);
			return;
		}

		// copy input file to output one byte at a time,
		try {
			// One byte at a time -> not efficient
//			int data;
//			while ((data = in.read()) != -1) {
//				out.write(data);
//			}
			// or using an array of bytes
			byte[] data = new byte[500];
			int n; // number of bytes read
			while((n = in.read(data)) != -1) {
				out.write(data, 0, n);
			}
		} catch (IOException e) {
			System.out.println("Problem making the copy");
			return;
		}

		// close both streams
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("couldn't close the streams");
			return;
		}
		
		System.out.println("The copy was successful");
	}
}
