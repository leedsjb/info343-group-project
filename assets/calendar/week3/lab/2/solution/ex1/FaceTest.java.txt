import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
        final Face f = new Face();
        f.setBackground(Color.cyan);
        cp.add(f, BorderLayout.CENTER);
        final JLabel jlbl = new JLabel("Don't worry, be happy!", SwingConstants.CENTER);
        cp.add(jlbl, BorderLayout.SOUTH);

        // Add two buttons
        JPanel northPanel = new JPanel();
        JButton beHappy = new JButton("Be happy");
        JButton beSad = new JButton("Be sad");
        northPanel.add(beHappy);
        northPanel.add(beSad);
        cp.add(northPanel,BorderLayout.NORTH);

        // Program the buttons' clicks
        beHappy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                f.beHappy();
                jlbl.setText("Don't worry, be happy!");
            }
        });
        beSad.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                f.beSad();
                jlbl.setText("Worry, be sad!");
            }
        });

        // Set window size and display
        frame.setSize(200,225);
        frame.show();
    }
}
