package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

public class Discount {

	private String amount;
	private String type;

	public String getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return
				"Discount{" +
						"amount = '" + amount + '\'' +
						",type = '" + type + '\'' +
						"}";
	}
}
