import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		// Create the model
		DrawingModel model = new DrawingModel();

		// Graphics
		JFrame frame = new JFrame("Display of shapes");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// View
		ShapePanel panel = new ShapePanel();
		frame.add(panel);
	}

}
