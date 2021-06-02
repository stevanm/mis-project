package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

public class RatingsItem {

	@SerializedName("rating")
	private String rating;

	public String getRating() {
		return rating;
	}
}