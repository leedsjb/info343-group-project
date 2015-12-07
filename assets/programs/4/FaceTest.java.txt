import java.awt.*;
import javax.swing.*;

/**
 * Demonstrate basic Java Swing graphics.
 */
public class FaceTest {

    /** Create a window with a smiley face inside it */
    public static void main(String[] args) {

        // create frame and give it a name
        JFrame frame = new JFrame("A Face");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();

        // Add the face and a label
        Face f = new Face();
        f.setBackground(Color.cyan);
        cp.add(f, BorderLayout.CENTER);
        JLabel jlbl = new JLabel("Don't worry, be happy!", SwingConstants.CENTER);
        cp.add(jlbl, BorderLayout.SOUTH);

        // set window size, location and display
        frame.setSize(200,225);
        frame.setLocation(200,200);
        frame.setVisible(true);
    }
}
