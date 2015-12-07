import javax.swing.*;
import java.awt.*;

/**
 * Display a ZaxScene in a window
 */

public class ZaxGame {

    public static void main(String[] args)
    {
        // The frame
        JFrame frame = new JFrame("Zax game");
        frame.setLocation(100,100);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // The panel inside the frame is the ZaxScene
        frame.setContentPane(new ZaxScene(400,400));

        // Show the frame
        frame.show();
        // Adjust the size of the frame so that it fits the scene exactly
        Insets insets = frame.getInsets();
        frame.setSize(frame.getWidth()+insets.left+insets.right,
                      frame.getHeight()+insets.top+insets.bottom);
        frame.show();
    }
}


