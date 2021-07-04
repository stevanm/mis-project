package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantInfo {

	@SerializedName("site-url")
	private String siteUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private String rating;

	@SerializedName("description")
	private String description;

	@SerializedName("restaurant-discount")
	private RestaurantDiscount restaurantDiscount;

	@SerializedName("ratings")
	private List<RatingsItem> ratings;

	@SerializedName("id")
	private String id;

	@SerializedName("value")
	private Object value;

	@SerializedName("address")
	private String address;

	@SerializedName("deliverable-area")
	private List<DeliverableAreaItem> deliverableArea;

	@SerializedName("delivery-fee")
	private String deliveryFee;

	public String getSiteUrl() {
		return siteUrl;
	}

	public String getRating() {
		return rating;
	}

	public String getDescription() {
		return description;
	}

	public RestaurantDiscount getRestaurantDiscount() {
		return restaurantDiscount;
	}

	public List<RatingsItem> getRatings() {
		return ratings;
	}

	public String getId() {
		return id;
	}

	public Object getValue() {
		return value;
	}

	public String getAddress() {
		return address;
	}

	public List<DeliverableAreaItem> getDeliverableArea() {
		return deliverableArea;
	}

	public String getName() {
		return name;
	}

	public String getDeliveryFee() {
		return deliveryFee;
	}
}