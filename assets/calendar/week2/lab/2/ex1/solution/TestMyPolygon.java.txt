import junit.framework.TestCase;
import java.awt.Color;
import java.awt.Point;

/**
 * To test some of the methods (equals and clone) of the MyPolygon class
 * 
 * @author CSC 143
 * 
 */
public class TestMyPolygon extends TestCase {

	public void testEqualsAndClone() {
		Point[] points = { new Point(10, 10), new Point(200, 50),
				new Point(100, 300) };
		MyPolygon p = new MyPolygon(points, Color.BLUE, true);

		// Basic tests of equals
		assertFalse(p.equals(null));
		assertTrue(p.equals(p));

		// Is the clone identical?
		MyPolygon q = (MyPolygon) p.clone();
		assertTrue(p.equals(q));

		// A change of points doesn't affect p (a deep copy was done in the
		// constructor)
		points[0].x = 100;
		points[0].y = 200;
		MyPolygon otherP = new MyPolygon(points, Color.BLUE, true);
		assertFalse(otherP.equals(p));

		// A change to an alias of p changes p
		MyPolygon pAlias = p;
		pAlias.setFill(false);
		assertTrue(p.equals(pAlias));
		// but not a previous deep copy of p
		assertFalse(q.equals(p));
		
		// Moving q should change q but not a clone of q
		MyPolygon qCopy = (MyPolygon) q.clone();
		q.moveBy(10, 10);
		assertFalse(q.equals(qCopy));
		
		// Adding a point changes q but not a clone of q
		qCopy = (MyPolygon) q.clone();
		q.addPoint(new Point(150, 150));
		assertFalse(q.equals(qCopy));
		

	}

}
