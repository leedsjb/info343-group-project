import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * A class to view the difference between linear probing and quadratic probing
 */

public class MyHashSetView extends JPanel {

	// The MyHashSet that is viewed
	private MyHashSet<MyString> set;

	/**
	 * Creates a MyHashSetView object
	 */
	public MyHashSetView() {
		this.set = new MyHashSet<MyString>();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(400, 400));
	}

	/**
	 * Read a set of words from a file, store them in hash set, and check the
	 * fill status of the hash table graphically
	 */
	public static void main(String[] args) {
		// Use the system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// could not switch to the system look and feel
			// ignore the problem
		}

		final JFrame frame = new JFrame("Test the MyHashSet class");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// A button to load a text file
		JButton btnLoadFile = new JButton("Open file");

		// Two radio buttons to select the type of collision scheme for
		// the hash table
		JRadioButton rbnLinear = new JRadioButton("Linear");
		JRadioButton rbnQuadratic = new JRadioButton("Quadratic");
		ButtonGroup group = new ButtonGroup();
		group.add(rbnLinear);
		group.add(rbnQuadratic);

		JPanel northPanel = new JPanel();
		northPanel.add(btnLoadFile);
		northPanel.add(rbnLinear);
		northPanel.add(rbnQuadratic);
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);

		// A panel to display the fill status of the hash table
		final MyHashSetView testPanel = new MyHashSetView();
		JScrollPane scrollPane = new JScrollPane(testPanel);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		// When changing the selection of the radio buttons, change the
		// collisionScheme field of the test panel accordingly
		rbnLinear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((JRadioButton) e.getSource()).isSelected()) {
					if (testPanel.set.getCollisionScheme() != MyHashSet.LINEAR_PROBING) {
						testPanel.set
								.setCollisionScheme(MyHashSet.LINEAR_PROBING);
						frame.repaint();
					}
				}
			}
		});
		rbnQuadratic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((JRadioButton) e.getSource()).isSelected()) {
					if (testPanel.set.getCollisionScheme() != MyHashSet.QUADRATIC_PROBING) {
						testPanel.set
								.setCollisionScheme(MyHashSet.QUADRATIC_PROBING);
						frame.repaint();
					}
				}
			}
		});
		rbnLinear.setSelected(true);

		// When clicking on the JButton, read a text file and put the words
		// in the set
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open a text file
				JFileChooser fileChooser = new JFileChooser("C:/windows");
				fileChooser.setFileFilter(new MyFileFilter());
				int userChoice = fileChooser.showOpenDialog(frame);
				if (userChoice == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					boolean success = testPanel.getWordsFromFile(file);
					if (!success) {
						JOptionPane.showMessageDialog(frame, "Input error",
								"The input file could not be read",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				frame.repaint();
			}
		});

		// Show the frame
		frame.setVisible(true);
	}

	/**
	 * Fill the set with the words in the given text file
	 * 
	 * @param file
	 *            the text file to read
	 * @return true if the file could be read, false otherwise
	 */
	private boolean getWordsFromFile(File file) {
		try {
			// Clear the set
			this.set.clear();
			// Read the file
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					MyString s = new MyString(st.nextToken());
					this.set.add(s);
				}
			}
		} catch (IOException ioe) {
			return false;
		}
		return true;
	}

	/**
	 * Display in this panel a grid that shows the fill status of the hash table
	 * of the set
	 * 
	 * @param g
	 *            the graphics context to draw with
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!this.set.isEmpty()) {
			boolean[] fillStatus = this.set.getHashFillStatus();
			if (fillStatus.length == 0) {
				return;
			}

			// Size of a square in the panel
			int size = 5;
			// Number of squares on one line
			int cols = Math.max(this.getWidth() / size, 3);
			// Number of lines in the grid
			// (1 extra square at the beginning and at the end of the line)
			int lines = Math.max(fillStatus.length / (cols - 2), 1) + 2;

			// Preferred size of the panel
			this.setPreferredSize(new Dimension(cols * size, lines * size));

			// Draw the squares in the panel
			for (int i = 0; i < fillStatus.length; i++) {
				Color c = ((fillStatus[i]) ? Color.red : Color.yellow);
				int line = i / (cols - 2);
				int col = i % (cols - 2);
				int x = size + col * size;
				int y = size + line * size;
				g.setColor(c);
				g.fillRect(x, y, size, size);
			}
		}
	}
}

/**
 * A class to define a file filter that accepts text file only
 */
class MyFileFilter extends javax.swing.filechooser.FileFilter {

	/**
	 * Gets a description of this file filter
	 * 
	 * @return a string that contains a description of this file filter
	 */
	public String getDescription() {
		return "*.txt";
	}

	/**
	 * Is the given file accepted by this filter?
	 * 
	 * @param file
	 *            the File to filter
	 * @return true if the file name ends with txt, false otherwise
	 */
	public boolean accept(File file) {
		if (file == null) {
			return false;
		} else if (file.isDirectory()) {
			return true;
		} else {
			return file.getName().endsWith(".txt");
		}
	}
}
