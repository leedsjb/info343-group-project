import java.awt.Graphics;

import javax.swing.JPanel;


public class PolygonPanel extends JPanel implements View{
	
	// the model that contains the data to be displayed
	private PolygonModel model;

	@Override
	public void update(PolygonModel m) {
		this.model = m;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(model.getColor());
		g.fillPolygon(model.getPolygon());
	}

}
