import java.awt.Polygon;
import java.util.ArrayList;

public class A {
	private ArrayList<Polygon> list = new ArrayList<Polygon>();

	// two A objects are equal if the elements of their lists
	// are equal one by one
	public boolean equals(Object obj) {
		// if (obj == null || obj.getClass() != A.class) {
		// or use instanceof since A is not inherited
		if (obj == this) {
			return true;
		}
		else if (!(obj instanceof A)) {
			return false;
		} else {
			A a = (A) obj;
			// compare a.list and this.list
			if (this.list.size() != a.list.size()) {
				return false;
			}
			for (int i = 0; i < list.size(); i++) {
				Polygon p1 = list.get(i);
				Polygon p2 = a.list.get(i);
				if (p1.npoints != p2.npoints) {
					return false;
				}
				for (int j = 0; j < p1.npoints; j++) {
					if (p1.xpoints[j] != p2.xpoints[j]
							|| p1.ypoints[j] != p2.ypoints[j]) {
						return false;
					}
				}
			}
			return true;
		}
	}
}
