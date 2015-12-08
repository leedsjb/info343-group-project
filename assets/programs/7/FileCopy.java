import java.io.*;
/**
 * Copy a file whose name is the first command line
 * argument to the file whose name is the second argument.  Print the
 * contents to System.out as we go.
 */
public class FileCopy {

    /**
     * Copy the file named in the first argument to a new file
     * whose name is given by the second argument
     */
    public static void main(String[] args) throws IOException {

        // quit if we don't have exactly two command-line arguments
        if (args.length != 2) {
            System.err.println("FileCopy requires two filenames as arguments");
            return;
        }

        // open input file and wrap it with a BufferedReader stream
        FileReader inFile;
        try {
            inFile = new FileReader(args[0]);
        } catch (IOException e) {
            System.err.println("exception opening file - exception object: ");
            System.err.println(e);
            return;
        }
        BufferedReader in = new BufferedReader(inFile);

        // open output file and wrap it with a PrintWriter
        FileWriter outFile;
        try {
            outFile = new FileWriter(args[1]);
        } catch (IOException e) {
            System.err.println("exception creating output file - exception object:");
            System.err.println(e);
            return;
        }
        PrintWriter out = new PrintWriter(outFile);

        // copy input file to output one line at a time,
        // and print lines on System.out also
        String line = in.readLine();
        while (line != null) {
            System.out.println(line);
            out.println(line);
            line = in.readLine();
        }

        // close both streams
        in.close();
        out.close();
    }
}
