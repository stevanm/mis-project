package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

public class RestaurantDiscount {

	@SerializedName("type")
	private String type;

	@SerializedName("value")
	private String value;

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}
}