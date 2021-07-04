package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantInfo {

	@SerializedName("site-url")
	private String siteUrl;

	@SerializedName("payment-methods")
	private List<PaymentMethodsItem> paymentMethods;

	@SerializedName("rating")
	private String rating;

	@SerializedName("description")
	private String description;

	@SerializedName("delivery-types")
	private String deliveryTypes;

	@SerializedName("restaurant-discount")
	private RestaurantDiscount restaurantDiscount;

	@SerializedName("restaurant-images")
	private List<String> restaurantImages;

	@SerializedName("ratings")
	private List<RatingsItem> ratings;

	@SerializedName("logo")
	private String logo;

	@SerializedName("id")
	private String id;

	@SerializedName("default-ad")
	private String defaultAd;

	@SerializedName("value")
	private Object value;

	@SerializedName("review-enabled")
	private String reviewEnabled;

	@SerializedName("address")
	private String address;

	@SerializedName("minimum-order-price")
	private String minimumOrderPrice;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("restaurant-url")
	private String restaurantUrl;

	@SerializedName("deliverable-area")
	private List<DeliverableAreaItem> deliverableArea;

	@SerializedName("total-food-items")
	private String totalFoodItems;

	@SerializedName("name")
	private String name;

	@SerializedName("delivery-fee")
	private String deliveryFee;

	public String getSiteUrl() {
		return siteUrl;
	}

	public List<PaymentMethodsItem> getPaymentMethods() {
		return paymentMethods;
	}

	public String getRating() {
		return rating;
	}

	public String getDescription() {
		return description;
	}

	public String getDeliveryTypes() {
		return deliveryTypes;
	}

	public RestaurantDiscount getRestaurantDiscount() {
		return restaurantDiscount;
	}

	public List<String> getRestaurantImages() {
		return restaurantImages;
	}

	public List<RatingsItem> getRatings() {
		return ratings;
	}

	public String getLogo() {
		return logo;
	}

	public String getId() {
		return id;
	}

	public String getDefaultAd() {
		return defaultAd;
	}

	public Object getValue() {
		return value;
	}

	public String getReviewEnabled() {
		return reviewEnabled;
	}

	public String getAddress() {
		return address;
	}

	public String getMinimumOrderPrice() {
		return minimumOrderPrice;
	}

	public List<Object> getTags() {
		return tags;
	}

	public String getRestaurantUrl() {
		return restaurantUrl;
	}

	public List<DeliverableAreaItem> getDeliverableArea() {
		return deliverableArea;
	}

	public String getTotalFoodItems() {
		return totalFoodItems;
	}

	public String getName() {
		return name;
	}

	public String getDeliveryFee() {
		return deliveryFee;
	}
}