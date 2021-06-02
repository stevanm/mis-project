package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantEntity {

	@SerializedName("restaurant-info")
	private RestaurantInfo restaurantInfo;

	@SerializedName("categorys")
	private List<CategorysItem> categorys;

	@SerializedName("working-hours-start")
	private String workingHoursStart;

	@SerializedName("restaurant-time-info")
	private RestaurantTimeInfo restaurantTimeInfo;

	@SerializedName("today")
	private String today;

	@SerializedName("deals")
	private List<Object> deals;

	@SerializedName("working-hours-end")
	private String workingHoursEnd;

	@SerializedName("type")
	private String type;

	public RestaurantInfo getRestaurantInfo() {
		return restaurantInfo;
	}

	public List<CategorysItem> getCategorys() {
		return categorys;
	}

	public String getWorkingHoursStart() {
		return workingHoursStart;
	}

	public RestaurantTimeInfo getRestaurantTimeInfo() {
		return restaurantTimeInfo;
	}

	public String getToday() {
		return today;
	}

	public List<Object> getDeals() {
		return deals;
	}

	public String getWorkingHoursEnd() {
		return workingHoursEnd;
	}

	public String getType() {
		return type;
	}
}