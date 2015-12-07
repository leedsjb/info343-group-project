import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Listens to the user's interactions with the application and takes proper
 * action
 * 
 * @author CSC 143
 *
 */
public class PolygonController implements ActionListener, ComponentListener,
		MouseListener {

	private PolygonModel model;

	/**
	 * Creates a controller connected to the given model
	 */
	public PolygonController(PolygonModel model) {
		this.model = model;
	}

	@Override
	/**
	 * Tells the model to create a new polygon
	 */
	public void actionPerformed(ActionEvent e) {
		model.createPolygon();
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent e) {
		model.setArea(e.getComponent().getWidth(), e.getComponent().getHeight());
		model.createPolygon();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		model.createPolygon();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
