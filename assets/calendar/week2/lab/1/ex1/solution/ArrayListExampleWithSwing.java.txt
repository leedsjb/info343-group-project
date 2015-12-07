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
        window = new JFrame("Array list example using Swing");
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Our panel goes in this window
        window.setContentPane(this);
        // Background color of the panel
        this.setBackground(Color.white);
        window.show();

        // Send all of the events on the window to this ArrayListExampleWithSwing
        this.addMouseListener(this); // mouse clicks on the panel
        window.addKeyListener(this); // keyboard events when the window is active

        // Create the square list (initially empty)
        squareList = new ArrayList();
        // and the list of colors
        colorList = new ArrayList();
    }

    /**
     * A key has been pressed. Create a square at a random location.
     */
    public void keyPressed(KeyEvent e)
    {
        // Center of the square (within this  Jpanel)
        int x = (int)(Math.random()*(this.getWidth()-side)+side/2);
        int y = (int)(Math.random()*(this.getHeight()-side)+side/2);

        // Color of the square (random)
        Color c = new Color((float)Math.random(),
                            (float)Math.random(),
                            (float)Math.random());
        colorList.add(c);

        // Create the square
        Rectangle r = new Rectangle(x-side/2,y-side/2,side,side);
        squareList.add(r);

        // Show it
        this.repaint();
    }

    /**
     * Mouse click on the window. If it is on a square, erase that square
     */
    public void mousePressed(MouseEvent e)
    {
        // Iterate over the squares (from the last one to the first one)
        for(int i=squareList.size()-1; i>=0; i--)
        {
            // Is the click on element i of squareList?
            Rectangle r = (Rectangle)(squareList.get(i));
            int x = e.getX();
            int y = e.getY();
            if (r.contains(x,y))
            {
                squareList.remove(i);
                colorList.remove(i);
                this.repaint();
                return;
            }
        }
    }

    /**
     * paint the window
     */
    public void paintComponent(Graphics g)
    {
        // Needed to paint in the right order
        super.paintComponent(g);

        // Display the squares
        Iterator itSquare = squareList.iterator();
        Iterator itColor = colorList.iterator();
        while(itSquare.hasNext())
        {
            Rectangle r = (Rectangle)itSquare.next();
            Color c = (Color)itColor.next();
            // Display the rectangle
            g.setColor(c);
            g.fillRect(r.x,r.y,r.width,r.height);
        }
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



