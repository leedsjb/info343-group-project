public class DiscountBill extends GroceryBill {
	private boolean preferred;

	private int discountCount;

	private double discountAmount;

	public DiscountBill(Employee clerk, boolean preferred) {
		super(clerk);
		this.preferred = preferred;
	}

	public void add(Item i) {
		if (preferred && i.getDiscount() > 0) {
			discountCount++;
			discountAmount += i.getDiscount();
		}
		super.add(i);
	}

	public int getDiscountCount() {
		return discountCount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public double getTotal() {
		return super.getTotal() - discountAmount;
	}

	public double getDiscountPercent() {
		return discountAmount / super.getTotal() * 100;
	}
}