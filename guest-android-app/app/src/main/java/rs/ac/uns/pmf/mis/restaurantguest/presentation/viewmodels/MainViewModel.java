package rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantRepository;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.RestaurantEntity;

public class MainViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository;

    public MainViewModel(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public LiveData<RestaurantEntity> getRestaurantData() {
        return restaurantRepository.getRestaurantData();
    }

}
