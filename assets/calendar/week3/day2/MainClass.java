import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass {

	public static void main(String[] args) {
		// Create the model
		PolygonModel model = new PolygonModel();

		// Graphics
		JFrame frame = new JFrame("Polygon display");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// View
		PolygonPanel panel = new PolygonPanel();
		frame.add(panel);
		
		// Controller
		PolygonController controller = new PolygonController(model);
		panel.addComponentListener(controller);
		frame.addMouseListener(controller);
		
		// add a button at the bottom of the frame
		JButton button = new JButton("Draw polygon");
		button.addActionListener(controller);
		JPanel southPanel = new JPanel();
		southPanel.add(button);
		frame.add(southPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
		model.setArea(panel.getWidth(), panel.getHeight());
		model.addView(panel);

	}

}
