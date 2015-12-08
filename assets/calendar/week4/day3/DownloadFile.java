import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

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
	public static void main(String[] args) throws Exception {
		// Need 2 arguments on the command line
		if (args.length != 2) {
			args = new String[] {
					"http://seattlecentral.edu/~flepeint/java143/class.html",
					"class.html" };
		}
		// The URL of the file to download
		URL url = new URL(args[0]);
		// The file that receives the download
		File file = new File(args[1]);

		// Create an input stream from the server
		InputStream in = url.openStream();
		// Create an output stream to the file to copy to
		OutputStream out = new FileOutputStream(file);
		// Make the copy
		byte[] data = new byte[500];
		int n; // number of bytes read
		while ((n = in.read(data)) != -1) {
			out.write(data, 0, n);
		}
		in.close();
		out.close();
		System.out.printf("%s has been downloaded to %s\n", 
				          args[0], args[1]);
	}

}





