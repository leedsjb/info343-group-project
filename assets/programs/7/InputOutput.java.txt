import javax.swing.*;
import uwcse.io.*;
import java.io.*;
import java.text.*;

/**
 * Different options of standard I/O in java
 *
 */
public class InputOutput
{
    /**
     * Examples of I/O
     */
    public static void main(String[] args)
    {
        // Input and output of an integer or a double
        int i;
        double x;
        String s;

        // use an Input object
        Input input = new Input();
        i = input.readInt("Enter an integer (will recover if bad input): ");
        System.out.println("i="+i);

        // use a JOptionPane method
        s = JOptionPane.showInputDialog(null,"Enter an integer (crashes if bad input)",
        "Integer input",JOptionPane.QUESTION_MESSAGE);
        i = Integer.parseInt(s); // may crash here if s is not an int written as a string
        JOptionPane.showMessageDialog(null,"i="+i,"Value of i",
        JOptionPane.INFORMATION_MESSAGE);

        // The complicated way
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Enter a double (crashes if bad input): ");
            s = r.readLine();
        }
        catch(IOException ioe){/* ignore any exception */}
        x = Double.parseDouble(s); // may crash here if s is not a double written as a string
        DecimalFormat d = new DecimalFormat("0.000");
        System.out.println("x="+d.format(x));

        // Terminate
        System.exit(0);
    }
}
