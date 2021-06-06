package rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantRepository;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.RestaurantEntity;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.SubItemsItem;

public class MainViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository;

    public MainViewModel(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public LiveData<RestaurantEntity> getRestaurantData() {
        return restaurantRepository.getRestaurantData();
    }

    public MutableLiveData<HashMap<String, SubItemsItem>> getOrderedItems() {
        return restaurantRepository.getOrderedItems();
    }

    public void addOrRemoveFromBill(boolean removeFromBill, SubItemsItem item) {
        restaurantRepository.addOrRemoveFromBill(removeFromBill, item);
    }

    public void clearRepositoryData(){
        restaurantRepository.clearRepositoryData();
    }
}
