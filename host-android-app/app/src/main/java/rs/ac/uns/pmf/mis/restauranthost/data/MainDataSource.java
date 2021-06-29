package rs.ac.uns.pmf.mis.restauranthost.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerEmployeeItem;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerOrderItem;

public class MainDataSource implements MainRepository {

    private final Application application;
    private List<ManagerOrderItem> managerOrderItems = new ArrayList<>();
    private List<ManagerEmployeeItem> managerEmployeeItems = new ArrayList<>();

    public MainDataSource(Application application) {
        this.application = application;
    }

    @Override
    public MutableLiveData<List<ManagerOrderItem>> getManagerOrderedItems() {
        managerOrderItems.add(new ManagerOrderItem("Artikal 1", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 2", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 3", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 4", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 5", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 6", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 7", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 8", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 9", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 10", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 11", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 12", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 13", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 14", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 15", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 16", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 17", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 18", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 19", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 20", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 21", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 22", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 23", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 24", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 25", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 26", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 27", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 28", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 29", 0));
        managerOrderItems.add(new ManagerOrderItem("Artikal 30", 0));
        return new MutableLiveData<>(managerOrderItems);
    }

    @Override
    public void sendManagerOrderedItems(List<ManagerOrderItem> managerOrderItems) {
        this.managerOrderItems = managerOrderItems;
    }

    @Override
    public LiveData<List<ManagerEmployeeItem>> getManagerEmployeeItems() {
        managerEmployeeItems.add(new ManagerEmployeeItem(1, "Pera", "Peric"));
        managerEmployeeItems.add(new ManagerEmployeeItem(2, "Mika", "Mikic"));
        managerEmployeeItems.add(new ManagerEmployeeItem(3, "Zika", "Zikic"));
        managerEmployeeItems.add(new ManagerEmployeeItem(4, "Laza", "Lazic"));
        managerEmployeeItems.add(new ManagerEmployeeItem(5, "Steva", "Stevic"));
        return new MutableLiveData<>(managerEmployeeItems);
    }

    @Override
    public void sendManagerEmployeeItems(List<ManagerEmployeeItem> managerEmployeeItems) {
        this.managerEmployeeItems = managerEmployeeItems;
    }

}
