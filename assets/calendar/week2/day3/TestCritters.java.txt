import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class TestCritters implements CritterConstants {

	@Test
	public void testLion() {
		int steps = 6;
		Lion lion = new Lion(steps);
		assertTrue(lion.toString().equals("L"));
		assertTrue(lion.fight(null) == PAPER);
		assertTrue(lion.getColor().equals(Color.YELLOW));
		// how to test move?
		int[] countDir = new int[4];
		int max = 100000;
		for (int k = 1; k <= max; k++) {
			int dir = lion.getMove(null); // 1st move
			if (dir == NORTH) {
				countDir[0]++;
			} else if (dir == EAST) {
				countDir[1] ++;
			} else if (dir == WEST) {
				countDir[2] ++;
			} else if (dir == SOUTH){
				countDir[3] ++;
			}
			// should be the same for the next steps - 1 moves
			for (int i = 1; i <= steps - 1; i++) {
				assertTrue(lion.getMove(null) == dir);
			}
		}
		// Do we get about max/4 for all of the counts?
		for(int ct : countDir) {
			assertTrue(ct <= 1.05 * max/4 && ct >= 0.95 * max/4);
		}
	}

}














