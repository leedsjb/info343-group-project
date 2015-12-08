import java.awt.*;
import javax.swing.*;

/**
 * A Smiley-face panel.
 */
public class Face extends JPanel {

    // number of times paintComponent has been called
    private static int ncalls = 0;

    /** Paint a smiley face centered in this Jpanel */
    public void paintComponent(Graphics g) {
        // report repaint for debugging
        ncalls++;
        System.out.println("paintComponent " + ncalls);

        // paint background
        super.paintComponent(g);

        // get width and height of drawing area, which is the
        // width and height of the JPanel minus the width and
        // height of any border.  The upper-left corner of the
        // available drawing area is (insets.left, insets.top)
        Insets insets = getInsets();
        int height = getHeight() - insets.top - insets.bottom;
        int width  = getWidth() - insets.left - insets.right;

        // draw face that takes up 80% of the JPanel
        int faceTop  = insets.top  + height/10;
        int faceLeft = insets.left + width/10;
        int faceHeight = height - height/5;
        int faceWidth  = width  - width/5;

        // outline
        g.setColor(Color.yellow);
        g.fillOval(faceLeft, faceTop, faceWidth, faceHeight);

        // eyes
        g.setColor(Color.black);
        g.fillOval(faceLeft+(int)(width*0.2), faceTop+(int)(height*0.2),
                    width/10, height/10);
        g.fillOval(faceLeft+(int)(width*0.5), faceTop+(int)(height*0.2),
                    width/10, height/10);

        // nose
        Polygon nose = new Polygon();
        nose.addPoint(faceLeft+(int)(width*0.40), faceTop+(int)(height*0.35));
        nose.addPoint(faceLeft+(int)(width*0.45), faceTop+(int)(height*0.50));
        nose.addPoint(faceLeft+(int)(width*0.35), faceTop+(int)(height*0.50));
        g.fillPolygon(nose);

        // mouth
        g.fillArc(faceLeft+(int)(width*0.25), faceTop+(int)(height*0.5),
                  (int)(width*0.3), (int)(height*0.2),
                  0, -180);

    }
}
