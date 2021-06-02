package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantTimeInfo {

	@SerializedName("thu")
	private List<ThuItem> thu;

	@SerializedName("tue")
	private List<TueItem> tue;

	@SerializedName("sat")
	private List<SatItem> sat;

	@SerializedName("wed")
	private List<WedItem> wed;

	@SerializedName("fri")
	private List<FriItem> fri;

	@SerializedName("sun")
	private List<SunItem> sun;

	@SerializedName("mon")
	private List<MonItem> mon;

	public List<ThuItem> getThu() {
		return thu;
	}

	public List<TueItem> getTue() {
		return tue;
	}

	public List<SatItem> getSat() {
		return sat;
	}

	public List<WedItem> getWed() {
		return wed;
	}

	public List<FriItem> getFri() {
		return fri;
	}

	public List<SunItem> getSun() {
		return sun;
	}

	public List<MonItem> getMon() {
		return mon;
	}
}