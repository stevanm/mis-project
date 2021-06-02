package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import java.util.List;

public class RestaurantInfo {

	private String siteUrl;
	private List<PaymentMethodsItem> paymentMethods;
	private String facebookLikeLink;
	private String openStatus;
	private String rating;
	private String description;
	private String deliveryTypes;
	private RestaurantDiscount restaurantDiscount;
	private List<String> restaurantImages;
	private String socialShare;
	private List<RatingsItem> ratings;
	private String logo;
	private String id;
	private String totalCategory;
	private String defaultAd;
	private Object value;
	private String reviewEnabled;
	private String locationImg;
	private String address;
	private String avgDeliveryTime;
	private String sponsored;
	private String minimumOrderPrice;
	private List<Object> tags;
	private String restaurantUrl;
	private String userFavourite;
	private List<DeliverableAreaItem> deliverableArea;
	private String totalFoodItems;
	private String name;
	private String deliveryFee;

	public String getSiteUrl() {
		return siteUrl;
	}

	public List<PaymentMethodsItem> getPaymentMethods() {
		return paymentMethods;
	}

	public String getFacebookLikeLink() {
		return facebookLikeLink;
	}

	public String getOpenStatus() {
		return openStatus;
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

	public String getSocialShare() {
		return socialShare;
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

	public String getTotalCategory() {
		return totalCategory;
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

	public String getLocationImg() {
		return locationImg;
	}

	public String getAddress() {
		return address;
	}

	public String getAvgDeliveryTime() {
		return avgDeliveryTime;
	}

	public String getSponsored() {
		return sponsored;
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

	public String getUserFavourite() {
		return userFavourite;
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

	@Override
	public String toString() {
		return
				"RestaurantInfo{" +
						"site-url = '" + siteUrl + '\'' +
						",payment-methods = '" + paymentMethods + '\'' +
						",facebook-like-link = '" + facebookLikeLink + '\'' +
						",open-status = '" + openStatus + '\'' +
						",rating = '" + rating + '\'' +
						",description = '" + description + '\'' +
						",delivery-types = '" + deliveryTypes + '\'' +
						",restaurant-discount = '" + restaurantDiscount + '\'' +
						",restaurant-images = '" + restaurantImages + '\'' +
						",social-share = '" + socialShare + '\'' +
						",ratings = '" + ratings + '\'' +
						",logo = '" + logo + '\'' +
						",id = '" + id + '\'' +
						",total-category = '" + totalCategory + '\'' +
						",default-ad = '" + defaultAd + '\'' +
						",value = '" + value + '\'' +
						",review-enabled = '" + reviewEnabled + '\'' +
						",location-img = '" + locationImg + '\'' +
						",address = '" + address + '\'' +
						",avg_delivery_time = '" + avgDeliveryTime + '\'' +
						",sponsored = '" + sponsored + '\'' +
						",minimum-order-price = '" + minimumOrderPrice + '\'' +
						",tags = '" + tags + '\'' +
						",restaurant-url = '" + restaurantUrl + '\'' +
						",user-favourite = '" + userFavourite + '\'' +
						",deliverable-area = '" + deliverableArea + '\'' +
						",total-food-items = '" + totalFoodItems + '\'' +
						",name = '" + name + '\'' +
						",delivery-fee = '" + deliveryFee + '\'' +
						"}";
	}
}