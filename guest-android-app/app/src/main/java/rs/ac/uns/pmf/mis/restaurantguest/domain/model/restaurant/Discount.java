package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

public class Discount {

	@SerializedName("amount")
	private String amount;

	@SerializedName("type")
	private String type;

	public String getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}
}