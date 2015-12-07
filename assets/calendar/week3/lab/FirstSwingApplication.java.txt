import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * How to create a simple graphics application with the java libraries
 * 
 * @author CSC 143
 *
 */
public class FirstSwingApplication {
	public static void main(String[] args) {
		JFrame frame = new JFrame("first swing application");
		// to terminate the program when closing the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		// A label at the top of the frame
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.GREEN);
		JLabel label = new JLabel("Display of a polygon");
		label.setFont(new Font("Courier", Font.BOLD | Font.ITALIC, 25));
		northPanel.add(label);
		frame.add(northPanel, BorderLayout.NORTH);

		// display a polygon in the frame
		JPanel centerPanel = new JPanel() {
			private Random rand = new Random();

			@Override
			protected void paintComponent(Graphics g) {
				// to get a good display, always call super.paintComponent first
				super.paintComponent(g);
				// Create a polygon
				int nPoints = rand.nextInt(10) + 10; // between 10 and 19 points
				int[] x = new int[nPoints];
				int[] y = new int[nPoints];
				for (int i = 0; i < nPoints; i++) {
					x[i] = rand.nextInt(getWidth());
					y[i] = rand.nextInt(getHeight());
				}
				Color c = new Color(rand.nextInt(), true); // true for
				// a partially opaque color
				g.setColor(c);
				Polygon p = new Polygon(x, y, nPoints);
				g.fillPolygon(p);
			}
		};
		frame.add(centerPanel, BorderLayout.CENTER);

		// a button at the bottom of the frame
		JButton button = new JButton("Draw polygon");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.repaint();

			}
		});
		JPanel southPanel = new JPanel();
		southPanel.add(button);
		frame.add(southPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
}
