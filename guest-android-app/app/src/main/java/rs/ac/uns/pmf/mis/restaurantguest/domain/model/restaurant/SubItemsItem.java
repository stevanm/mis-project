package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubItemsItem {

	@SerializedName("cuisine_name")
	private String cuisineName;

	@SerializedName("category_name")
	private String categoryName;

	@SerializedName("price")
	private String price;

	@SerializedName("consumable")
	private String consumable;

	@SerializedName("name")
	private String name;

	@SerializedName("discount")
	private Discount discount;

	@SerializedName("id")
	private String id;

	@SerializedName("position")
	private Integer position;

	@SerializedName("tags")
	private List<Object> tags;

	public String getCuisineName() {
		return cuisineName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getPrice() {
		return price;
	}

	public String getConsumable() {
		return consumable;
	}

	public String getName() {
		return name;
	}

	public Discount getDiscount() {
		return discount;
	}

	public String getId() {
		return id;
	}

	public Integer getPosition() {
		return position;
	}

	public List<Object> getTags() {
		return tags;
	}
}