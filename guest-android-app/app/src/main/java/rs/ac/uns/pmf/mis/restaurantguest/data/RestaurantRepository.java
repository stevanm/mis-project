package rs.ac.uns.pmf.mis.restaurantguest.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.RestaurantEntity;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.SubItemsItem;

public interface RestaurantRepository {

    LiveData<RestaurantEntity> getRestaurantData();

    MutableLiveData<HashMap<String, SubItemsItem>>  getOrderedItems();

    void addOrRemoveFromBill(boolean removeFromBill, SubItemsItem item);

    void clearRepositoryData();
}
