package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

public class DeliverableAreaItem {

	private String name;
	private String id;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return
				"DeliverableAreaItem{" +
						"name = '" + name + '\'' +
						",id = '" + id + '\'' +
						"}";
	}
}
