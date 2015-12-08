import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A simple illustration to answer the question
 * "why is it better for a hash table to have a size 
 * that is a prime number?"
 * (For a quadratic probing collision scheme in an open addressing strategy).
 */
public class HashAndPrimeNumber {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Try 9973 and then 10000 and see the difference
		// with 9973, 50% of the elements are checked
		// with 10000, 10 % of the elements are checked
		MyPanel panel = new MyPanel(9973);
		panel.setBackground(Color.WHITE);
		frame.add(panel);
		frame.setVisible(true);

		Insets insets = frame.getInsets();
		frame.setSize(insets.left + 500 + insets.right, insets.top + 500
				+ insets.bottom);
		frame.repaint();

		Timer timer = new Timer(10, panel);
		timer.start();
	}

}

// the elements tried successively via quadratic probing are painted 
// as red squares in a panel.
class MyPanel extends JPanel implements ActionListener {

	private int[] data;
	private int index = 0;
	private int step = 0;
	private int chunk = 10;
	private double sum = 0;

	public MyPanel(int n) {
		data = new int[n];
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (data != null) {
			// each element is a 5x5 square
			// 100 hundred squares along the horizontal
			g.setColor(Color.RED);
			for (int i = 0; i < data.length; i++) {
				if (data[i] != 0) {
					int x = (i % 100) * 5;
					int y = (i / 100) * 5;
					g.fillRect(x, y, 5, 5);
				}
			}
		}

	}

	public void actionPerformed(ActionEvent e) {
		// Add more elements to the array and repaint
		boolean change = false;
		for (int i = 1; i <= chunk; i++) {
			// quadratic probing: try index, index + 1^2, index + 2^2, index + 3^2, etc.
			int j = Math.abs((index + step * step)) % data.length;
			if (data[j] == 0) {
				sum++;
				change = true;
				data[j] = 1;
			}
			step++;
		}
		if (change) {
			System.out.println("checked = "
					+ NumberFormat.getPercentInstance().format(
							(double) sum / data.length));
		}
		repaint();

	}
}
