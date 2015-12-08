import java.util.ArrayList;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * In a graphics window, place at random location a square when a key
 * is pressed on the keyboard. Delete that square if it is clicked with
 * the mouse. Keep track of the squares with an ArrayList
 */

public class ArrayListExampleWithSwing extends JPanel implements KeyListener, MouseListener {

    // Keep the list of squares in an ArrayList
    private ArrayList squareList;
    // The list of the colors of the squares
    private ArrayList colorList;
    // The window our panel belongs to
    private JFrame window;
    // length of the side of the squares
    private int side = 20;

    /**
     * Initialize the graphics window and the list of squares
     */
    public ArrayListExampleWithSwing()
    {
        // Create the graphics window

        // Our panel goes in this window

        // Background color of the panel

        // Show the window

        // Send all of the events on the window to this ArrayListExampleWithSwing

        // Create the square list (initially empty)

        // and the list of colors

    }

    /**
     * A key has been pressed. Create a square at a random location.
     */
    public void keyPressed(KeyEvent e)
    {
        // Center of the square


        // Color of the square (random)


        // Create the square

        // Show it

    }

    /**
     * Mouse click on the window. If it is on a square, erase that square
     */
    public void mousePressed(MouseEvent e)
    {
        // Iterate over the squares (from the last one to the first one)
    }

    /**
     * paint the window
     */
    public void paintComponent(Graphics g)
    {
        // Needed to paint in the right order
        super.paintComponent(g);

        // Display the squares
    }

    // Other methods needed to implement the interfaces
    // from MouseListener
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    // from KeyListener
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}



