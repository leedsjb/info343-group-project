import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<DrawingView> views = new ArrayList<DrawingView>();
	
	// updates all of the views connected to this model
	public void updateViews() {
		for (DrawingView view : views) {
			view.update(this);
		}
	}

	// Adds a new view to the model
	public void addView(DrawingView view) {
		views.add(view);
		view.update(this);
	}
	
	// Returns the deep copy of the list of shapes
	public List<Shape> getShapes() {
		List<Shape> copy = new ArrayList<Shape>();
		for (Shape s : shapes) {
			copy.add(s.deepCopy());
		}
		return copy;
	}

}







