package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import java.util.List;

public class SubItemsItem {

	private String cuisineName;
	private String categoryName;
	private String price;
	private String consumable;
	private String name;
	private Discount discount;
	private String id;
	private int position;
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

	public int getPosition() {
		return position;
	}

	public List<Object> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return
				"SubItemsItem{" +
						"cuisine_name = '" + cuisineName + '\'' +
						",category_name = '" + categoryName + '\'' +
						",price = '" + price + '\'' +
						",consumable = '" + consumable + '\'' +
						",name = '" + name + '\'' +
						",discount = '" + discount + '\'' +
						",id = '" + id + '\'' +
						",position = '" + position + '\'' +
						",tags = '" + tags + '\'' +
						"}";
	}
}