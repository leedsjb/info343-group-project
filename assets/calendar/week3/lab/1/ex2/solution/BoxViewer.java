import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class BoxViewer extends JPanel {

  // The box viewed by this viewer
  private Box box;

  /**
   * Creates a box viewer within a frame
   */
  public BoxViewer() {
    setBackground(Color.white);

    // The box
    box = new Box(250, 250, 200, 200, Color.red);
    System.out.println(box);

    // Create a frame for this panel
    JFrame frame = new JFrame("Box viewer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.getContentPane().add(this);
    frame.show();

    // A click on the frame adds an inner box to the box
    this.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        box.addInnerBox();
        System.out.println(box);
        repaint();
      }
    }
    );
  }

  /**
   * Paints the contents of this viewer
   * @param g the graphics context to use.
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (box != null) box.draw(g);
  }

  /**
   * Starts the application.
   * @param args the list of the command line parameters.
   */
  public static void main(String[] args) {
    new BoxViewer();
  }
}














