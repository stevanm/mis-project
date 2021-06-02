package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

public class PaymentMethodsItem {

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}
}