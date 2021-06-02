package rs.ac.uns.pmf.mis.restaurantguest.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import rs.ac.uns.pmf.mis.restaurantguest.R;
import rs.ac.uns.pmf.mis.restaurantguest.domain.model.restaurant.RestaurantEntity;

public class RestaurantDataSource implements RestaurantRepository {

    private Application application;

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
}
