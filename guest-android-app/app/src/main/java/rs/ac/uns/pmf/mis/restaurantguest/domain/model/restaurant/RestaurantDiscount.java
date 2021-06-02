package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

public class RestaurantDiscount {

	private String type;
	private String value;

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return
				"RestaurantDiscount{" +
						"type = '" + type + '\'' +
						",value = '" + value + '\'' +
						"}";
	}
}
