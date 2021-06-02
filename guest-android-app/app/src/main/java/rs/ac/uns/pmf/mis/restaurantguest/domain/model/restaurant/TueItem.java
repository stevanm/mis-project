package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

public class TueItem {

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
				"TueItem{" +
						"close = '" + close + '\'' +
						",open = '" + open + '\'' +
						"}";
	}
}
