package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import java.util.List;

public class MenuItemsItem {

	private List<SubItemsItem> subItems;
	private List<Object> images;
	private String name;
	private String description;
	private String id;
	private int position;

	public List<SubItemsItem> getSubItems() {
		return subItems;
	}

	public List<Object> getImages() {
		return images;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return
				"MenuItemsItem{" +
						"sub-items = '" + subItems + '\'' +
						",images = '" + images + '\'' +
						",name = '" + name + '\'' +
						",description = '" + description + '\'' +
						",id = '" + id + '\'' +
						",position = '" + position + '\'' +
						"}";
	}
}