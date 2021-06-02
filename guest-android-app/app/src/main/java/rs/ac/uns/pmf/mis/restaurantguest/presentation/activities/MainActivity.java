package rs.ac.uns.pmf.mis.restaurantguest.presentation.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import rs.ac.uns.pmf.mis.restaurantguest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remove action bar
        if (null != getSupportActionBar()) {
            getSupportActionBar().hide();
        }


    }
}