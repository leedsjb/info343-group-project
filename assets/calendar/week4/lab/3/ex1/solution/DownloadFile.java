import java.io.*;
import java.net.*;

/**
 * A simple utility to download a file
 */

public class DownloadFile {
	/**
	 * Copies a file located by its URL to a local file The URL is the first
	 * command line argument. The local file name is the second command line
	 * argument.
	 * 
	 * @param args
	 *            the array of the command line arguments.
	 */
	public static void main(String[] args) {
		if (args == null || args.length != 2) {
			System.out.println("Use: DownloadFile URLOfFileFrom FileTo");
			return;
		}

		// The URL of the file to download
		String URLName = args[0];
		// The file that receives the download
		String fileName = args[1];

		// URL of the file
		URL fileURL = null;
		try {
			fileURL = new URL(URLName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("Can't create URL");
			return;
		}

		// Create the file (This step is not needed since creating the stream
		// creates the file automatically.
		// This is just given as information).
		fileName = fileName.replace('/', File.separatorChar);

		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Could not create the file");
				return;
			}
		}

		// Create an input stream from the server
		InputStream in = null;
		try {
			in = fileURL.openStream();
		} catch (IOException e) {
			System.err.println("Can't open the stream");
			e.printStackTrace();
			return;
		}

		// Create an output stream to the destination file
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Make the copy
		try {
			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}

			// Close the streams
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}