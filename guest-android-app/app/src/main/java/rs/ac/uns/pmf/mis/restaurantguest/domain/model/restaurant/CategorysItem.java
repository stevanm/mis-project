package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import java.util.List;

public class CategorysItem {

	private List<MenuItemsItem> menuItems;
	private String name;
	private String id;
	private String position;

	public List<MenuItemsItem> getMenuItems() {
		return menuItems;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return
				"CategorysItem{" +
						"menu-items = '" + menuItems + '\'' +
						",name = '" + name + '\'' +
						",id = '" + id + '\'' +
						",position = '" + position + '\'' +
						"}";
	}
}