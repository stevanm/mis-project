package rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restauranthost.data.MainRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final MainRepository repository;

    public MainViewModelFactory(@NonNull @NotNull Application application,
                                MainRepository mainRepository) {
        repository = mainRepository;
    }

    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        try {
            return (T) new MainViewModel(repository);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
