package rs.ac.uns.pmf.mis.restaurantguest.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import rs.ac.uns.pmf.mis.restaurantguest.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //remove action bar
        if (null != getSupportActionBar()) {
            getSupportActionBar().hide();
        }

        // open main screen after 2 secs
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }

}