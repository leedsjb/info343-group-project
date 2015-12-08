import java.awt.*;
import javax.swing.*;

/**
 * An abstract class to represent what any Zax should be able to do
 */

public abstract class Zax {

    // Position of the center of this Zax
    protected int x,y;
    // The panel this Zax belongs to
    protected JPanel panel;

    // Some graphics constants to draw this Zax
    protected final int HEAD_SIZE = 36;
    protected final int EYE_WIDTH = 7;
    protected final int EYE_HEIGHT = 16;
    protected final int IRIS_SIZE = 4;
    protected final Color IRIS_COLOR = Color.blue;
    protected final Color EYE_COLOR = Color.white;
    protected final Color HEAD_COLOR = Color.green;

    // The distance covered by this Zax in one step (in pixels)
    protected final int STEP_SIZE = 2;

    /**
     * Create a Zax at position (x,y) in a JPanel
     */
    public Zax(int x, int y, JPanel panel)
    {
    }

    // What a Zax should be able to do. Even though we can't define
    // these methods, we declare them to make sure that all subclasses
    // implement them.
    /**
     * Move the Zax forward
     */
    public abstract void goForward();

    /**
     * draw the Zax in its graphics window
     */
    public abstract void draw(Graphics g);

    /**
     * Return the position of this Zax
     */
    public Point getPosition()
    {
    }

    /**
     * Return the size of this zax
     */
    public int getSize()
    {
    }
}