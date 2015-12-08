import java.awt.*;
import javax.swing.*;

/**
 * Define a Zax that walks northward
 */

public class NorthGoingZax extends Zax {

    /**
     * Create a Zax that walks northward
     */
    public NorthGoingZax(int x, int y, JPanel panel)
    {
        // Call the constructor of the superclass
        super(x,y,panel);
    }

    /**
     * Draw a north going zax
     */
    public void draw(Graphics g)
    {
        // Head of the Zax
        g.setColor(this.HEAD_COLOR);
        g.fillOval(this.x-this.HEAD_SIZE/2,this.y-this.HEAD_SIZE/2,
                   this.HEAD_SIZE,this.HEAD_SIZE);
        // Eyes of this north going zax
        // Left eye
        this.drawEye(g,this.x-this.HEAD_SIZE/4,this.y-this.HEAD_SIZE/6);
        // Right eye
        this.drawEye(g,this.x+this.HEAD_SIZE/4,this.y-this.HEAD_SIZE/6);
    }
    /**
     * Draw an eye in the head centered at position (x,y)
     * for a north going zax
     */
    private void drawEye(Graphics g, int x, int y)
    {
        // The eye
        g.setColor(this.EYE_COLOR);
        g.fillOval(x-this.EYE_WIDTH/2,y-this.EYE_HEIGHT/2,
                   this.EYE_WIDTH,this.EYE_HEIGHT);

        // Iris of the eye
        g.setColor(this.IRIS_COLOR);
        g.fillOval(x-(this.EYE_WIDTH-this.IRIS_SIZE)/2,
                   y-this.EYE_HEIGHT/2+this.IRIS_SIZE/2,
                   this.IRIS_SIZE,this.IRIS_SIZE);
    }

    /**
     * Move this Zax to the north
     */
    public void goForward()
    {
        y -= STEP_SIZE;
        this.panel.repaint();
    }
}