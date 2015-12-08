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
        this.width = width;
        this.height = height;

        // Background color of the scene
        this.setBackground(Color.yellow);

        // Create the buttons
        this.setLayout(null); // place the graphics elements in the panel with their coordinates
        Font font = new Font("Times",Font.BOLD,11);
        this.goNorth = new JButton("Move north going zax");
        this.goNorth.setLocation(10,2*this.height/3-10);
        this.goNorth.setSize(160,20);
        this.goNorth.setFont(font);
        this.add(this.goNorth);
        this.goNorth.addActionListener(this);
        this.goSouth = new JButton("Move south going zax");
        this.goSouth.setLocation(10,this.height/3-10);
        this.goSouth.setSize(160,20);
        this.goSouth.setFont(font);
        this.add(this.goSouth);
        this.goSouth.addActionListener(this);

        // Create the zaxes
        this.nz = new NorthGoingZax(250,this.height-25,this);
        this.sz = new SouthGoingZax(250,25,this);

        // Show the scene
        this.repaint();
    }

    /**
     * If one of the buttons is pressed, move the corresponding zax
     */
    public void actionPerformed(ActionEvent e)
    {
        // Don't move the zax if it is head to head with the other zax
        Point nzPosition = this.nz.getPosition();
        Point szPosition = this.sz.getPosition();
        if (nzPosition.distance(szPosition)<=(this.nz.getSize()+this.sz.getSize())/2.)
            return;

        // north button
        if (e.getSource() == this.goNorth)
            this.nz.goForward();
        // south button
        else if(e.getSource() == this.goSouth)
            this.sz.goForward();

        // Show the new scene
        this.repaint();
    }

    /**
     * Paint the zax scene
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.sz.draw(g);
        this.nz.draw(g);
    }
}







