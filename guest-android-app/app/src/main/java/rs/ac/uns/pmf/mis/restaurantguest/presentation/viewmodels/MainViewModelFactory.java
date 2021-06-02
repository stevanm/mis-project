package rs.ac.uns.pmf.mis.restaurantguest.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final RestaurantRepository repository;

    public MainViewModelFactory(@NonNull @org.jetbrains.annotations.NotNull Application application,
                                RestaurantRepository restaurantRepository) {
        repository = restaurantRepository;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        return (T) new MainViewModel(repository);
    }

}
