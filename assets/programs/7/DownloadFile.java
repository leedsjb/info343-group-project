import java.io.*;
import java.net.*;

/**
 * Save a file to your computer given the URL of that file
 */

public class DownloadFile
{
    public static void main(String[] args)
    {
        if (args==null || args.length != 2)
        {
            System.out.println("Use: DownloadFile URLOfFileFrom FileTo");
            System.exit(0);
        }

        // The URL of the file to download
        String URLName = args[0];
        // The file that receives the download
        String fileName = args[1];

        // URL of the file
        URL fileURL = null;
        try{
            fileURL = new URL(URLName);
        }
        catch(MalformedURLException e1){
            e1.printStackTrace();
            System.err.println("Can't create URL");
            return;
        }

        // Create the file
        fileName = fileName.replace('/',File.separatorChar);

        File file = new File(fileName);
        if (!file.exists())
        {
            try{
                file.createNewFile();
            }
            catch(IOException e2){
                e2.printStackTrace();
                System.err.println("Could not create the file");
                return;
            }
        }

        // Create an input stream from the server
        InputStream in=null;
        try{
            in = fileURL.openStream();
        }
        catch(IOException e3){
            System.err.println("Can't open the stream");
            e3.printStackTrace();
            return;
        }

        // Create an output stream to the file to copy to
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(file);
        }
        catch(FileNotFoundException e4){
            e4.printStackTrace();
        }

        // Make the copy
        try{
            int i;
            do{
                i = in.read(); // one byte at a time
                if (i!=-1) out.write(i);
            }
            while(i!=-1);

            // Close the streams
            in.close();
            out.close();
        }
        catch(IOException e5){
            e5.printStackTrace();
        }
    }

}