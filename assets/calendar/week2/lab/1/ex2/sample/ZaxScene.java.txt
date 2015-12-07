import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A ZaxScene is the graphical display of one NorthGoingZax and one
 * SouthGoingZax. The two zaxes move along the same vertical line. <br>
 * Initially, the NorthGoingZax is at the bottom of the window
 * and the SouthGoingZax is at the top of the window. <br>
 * Two buttons allow the user to move each zax
 */

public class ZaxScene extends JPanel implements ActionListener {

    // Size of the scene
    private int width;
    private int height;

    // The elements of the scene
    private JButton goNorth;
    private JButton goSouth;
    private NorthGoingZax nz;
    private SouthGoingZax sz;

    /**
     * Construct the scene
     */
    public ZaxScene(int width, int height)
    {
        // Dimensions of the scene


        // Background color of the scene


        // place the graphics elements in the panel with their coordinates
        // (use setLayout)

        // Create the buttons (location, size)
        // This ZaxScene listens to the buttons

        // Create the zaxes

        // Show the scene
    }

    /**
     * If one of the buttons is pressed, move the corresponding zax
     */
    public void actionPerformed(ActionEvent e)
    {
        // Don't move the zax if it is head to head with the other zax


        // north button

        // south button


        // Show the new scene

    }

    /**
     * Paint the zax scene
     */
    public void paintComponent(Graphics g)
    {

    }
}







