package rs.ac.uns.pmf.mis.restaurantguest.framework;

import android.app.Application;

import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantDataSource;
import rs.ac.uns.pmf.mis.restaurantguest.data.RestaurantRepository;

public class RestaurantApplication extends Application {

    public AppContainer appContainer;

    @Override
    public void onCreate() {
        super.onCreate();

        appContainer = new AppContainer(this);

    }

    public RestaurantRepository getRestaurantRepository() {
        return appContainer.getRestaurantRepository();
    }

    private class AppContainer {

        private Application application;
        private RestaurantRepository restaurantRepository;

        public AppContainer(Application application) {
            this.application = application;
            restaurantRepository = new RestaurantDataSource(application);
        }

        public RestaurantRepository getRestaurantRepository() {
            return restaurantRepository;
        }

    }

}
