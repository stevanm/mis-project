package rs.ac.uns.pmf.mis.restauranthost.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}