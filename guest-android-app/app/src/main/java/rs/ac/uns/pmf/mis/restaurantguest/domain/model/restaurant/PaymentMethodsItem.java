package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

public class PaymentMethodsItem {

	private String id;
	private String type;

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return
				"PaymentMethodsItem{" +
						"id = '" + id + '\'' +
						",type = '" + type + '\'' +
						"}";
	}
}
