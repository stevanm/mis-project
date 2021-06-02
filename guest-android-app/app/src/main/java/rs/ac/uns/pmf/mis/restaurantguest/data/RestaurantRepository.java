package rs.ac.uns.pmf.mis.restaurantguest.data;

import androidx.lifecycle.LiveData;

import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.RestaurantEntity;

public interface RestaurantRepository {

    LiveData<RestaurantEntity> getRestaurantData();

}
