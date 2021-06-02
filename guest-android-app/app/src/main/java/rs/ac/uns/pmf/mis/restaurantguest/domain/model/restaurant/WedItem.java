package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

public class WedItem {

	private String close;
	private String open;

	public String getClose() {
		return close;
	}

	public String getOpen() {
		return open;
	}

	@Override
	public String toString() {
		return
				"WedItem{" +
						"close = '" + close + '\'' +
						",open = '" + open + '\'' +
						"}";
	}
}
