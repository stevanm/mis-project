package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantEntity {

	@SerializedName("restaurant-info")
	private RestaurantInfo restaurantInfo;

	@SerializedName("categorys")
	private List<CategorysItem> categorys;

	@SerializedName("restaurant-time-info")
	private RestaurantTimeInfo restaurantTimeInfo;

	@SerializedName("type")
	private String type;

	public RestaurantInfo getRestaurantInfo() {
		return restaurantInfo;
	}

	public List<CategorysItem> getCategorys() {
		return categorys;
	}

	public RestaurantTimeInfo getRestaurantTimeInfo() {
		return restaurantTimeInfo;
	}

	public String getType() {
		return type;
	}
}