public class CritterInfoForTest implements CritterInfo, CritterConstants {
	private String[] animals;

	public CritterInfoForTest(String[] animals) {
		this.animals = animals;
	}

	@Override
	public String getNeighbor(int direction) {
		// create animals around the current position
		if (direction == WEST) {
			return animals[0];
		} else if (direction == NORTH) {
			return animals[1];
		} else {
			return "";
		}
	}

}
