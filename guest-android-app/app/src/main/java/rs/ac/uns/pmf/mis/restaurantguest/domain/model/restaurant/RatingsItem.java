package rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant;

public class RatingsItem {

	private String rating;

	public String getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return
				"RatingsItem{" +
						"rating = '" + rating + '\'' +
						"}";
	}
}
