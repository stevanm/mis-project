package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

public class TueItem {

	@SerializedName("close")
	private String close;

	@SerializedName("open")
	private String open;

	public String getClose() {
		return close;
	}

	public String getOpen() {
		return open;
	}
}