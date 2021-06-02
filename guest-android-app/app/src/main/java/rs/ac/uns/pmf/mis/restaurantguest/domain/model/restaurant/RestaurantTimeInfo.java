package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

import java.util.List;

public class RestaurantTimeInfo {

	private List<ThuItem> thu;
	private List<TueItem> tue;
	private List<SatItem> sat;
	private List<WedItem> wed;
	private List<FriItem> fri;
	private List<SunItem> sun;
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

	@Override
	public String toString() {
		return
				"RestaurantTimeInfo{" +
						"thu = '" + thu + '\'' +
						",tue = '" + tue + '\'' +
						",sat = '" + sat + '\'' +
						",wed = '" + wed + '\'' +
						",fri = '" + fri + '\'' +
						",sun = '" + sun + '\'' +
						",mon = '" + mon + '\'' +
						"}";
	}
}