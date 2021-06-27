package rs.ac.uns.pmf.mis.restauranthost.data;

import androidx.lifecycle.LiveData;

import java.util.List;

import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerOrderItem;

public interface MainRepository {

    LiveData<List<ManagerOrderItem>> getManagerOrderedItems();

    void sendManagerOrderedItems(List<ManagerOrderItem> managerOrderItems);

}
