package rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import rs.ac.uns.pmf.mis.restauranthost.data.MainRepository;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerEmployeeItem;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerOrderItem;

public class MainViewModel extends ViewModel {

    private final MainRepository mainRepository;

    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public LiveData<List<ManagerOrderItem>> getManagerOrderedItems() {
        return mainRepository.getManagerOrderedItems();
    }

    public void sendManagerOrderedItems(List<ManagerOrderItem> managerOrderItems) {
        mainRepository.sendManagerOrderedItems(managerOrderItems);
    }

    public LiveData<List<ManagerEmployeeItem>> getManagerEmployeeItem() {
        return mainRepository.getManagerEmployeeItems();
    }

    public void sendManagerEmployeeItems(List<ManagerEmployeeItem> managerEmployeeItems) {
        mainRepository.sendManagerEmployeeItems(managerEmployeeItems);
    }
}
