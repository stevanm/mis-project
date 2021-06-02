package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

public class DeliverableAreaItem {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}