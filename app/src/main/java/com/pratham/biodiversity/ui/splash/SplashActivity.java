package com.pratham.biodiversity.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.pratham.biodiversity.ui.home.MainActivity;
import com.pratham.biodiversity.R;
import com.pratham.biodiversity.ui.home.MainActivity_;

public class SplashActivity extends AppCompatActivity {

     private Handler mWaitHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Intent intent = new Intent(getApplicationContext(), MainActivity_.class);
                    startActivity(intent);
                    finish();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);  // Give a 5 seconds delay.
    }
}
