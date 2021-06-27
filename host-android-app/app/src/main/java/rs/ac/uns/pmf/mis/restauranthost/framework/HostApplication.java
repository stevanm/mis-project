package rs.ac.uns.pmf.mis.restauranthost.framework;

import android.app.Application;

import rs.ac.uns.pmf.mis.restauranthost.data.MainDataSource;
import rs.ac.uns.pmf.mis.restauranthost.data.MainRepository;

public class HostApplication extends Application {

    public AppContainer appContainer;

    @Override
    public void onCreate() {
        super.onCreate();

        appContainer = new AppContainer(this);

    }

    public MainRepository getMainRepository() {
        return appContainer.getMainRepository();
    }

    private class AppContainer {

        private Application application;
        private MainRepository mainRepository;

        public AppContainer(Application application) {
            this.application = application;
            mainRepository = new MainDataSource(application);
        }

        public MainRepository getMainRepository() {
            return mainRepository;
        }

    }

}
