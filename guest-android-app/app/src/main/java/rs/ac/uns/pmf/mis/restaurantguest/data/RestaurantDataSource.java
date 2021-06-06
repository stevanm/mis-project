package rs.ac.uns.pmf.mis.restaurantguest.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.RestaurantEntity;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.SubItemsItem;

public class RestaurantDataSource implements RestaurantRepository {

    private final Application application;
    private final MutableLiveData<HashMap<String, SubItemsItem>> orderedItems = new MutableLiveData<>(new HashMap<>());

    public RestaurantDataSource(Application application) {
        this.application = application;
    }

    @Override
    public LiveData<RestaurantEntity> getRestaurantData() {
        RestaurantEntity restaurantEntity = null;
        InputStream inputStream = application.getResources().openRawResource(R.raw.order_menu);
        String jsonString = null;
        try {
            jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        restaurantEntity = new Gson().fromJson(jsonString, RestaurantEntity.class);
        MutableLiveData<RestaurantEntity> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(restaurantEntity);
        return mutableLiveData;
    }

    @Override
    public MutableLiveData<HashMap<String, SubItemsItem>> getOrderedItems() {
        return orderedItems;
    }

    @Override
    public void addOrRemoveFromBill(boolean removeFromBill, SubItemsItem item) {
        String itemId = item.getId();
        HashMap<String, SubItemsItem> map = orderedItems.getValue();
        if (removeFromBill) {
            if (null != map) {
                map.remove(itemId);
            }
        } else {
            if (null != map) {
                map.put(itemId, item);
            }
        }
        orderedItems.postValue(map);
    }

    @Override
    public void clearRepositoryData() {
        HashMap<String, SubItemsItem> map = orderedItems.getValue();
        if (null != map) {
            map.clear();
            orderedItems.postValue(map);
        }

    }

}
