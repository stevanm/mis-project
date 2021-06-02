package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import java.util.List;

public class RestaurantEntity {

	private RestaurantInfo restaurantInfo;
	private List<CategorysItem> categorys;
	private String workingHoursStart;
	private RestaurantTimeInfo restaurantTimeInfo;
	private String today;
	private List<Object> deals;
	private String workingHoursEnd;
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

	@Override
	public String toString() {
		return
				"MenuEntity{" +
						"restaurant-info = '" + restaurantInfo + '\'' +
						",categorys = '" + categorys + '\'' +
						",working-hours-start = '" + workingHoursStart + '\'' +
						",restaurant-time-info = '" + restaurantTimeInfo + '\'' +
						",today = '" + today + '\'' +
						",deals = '" + deals + '\'' +
						",working-hours-end = '" + workingHoursEnd + '\'' +
						",type = '" + type + '\'' +
						"}";
	}
}