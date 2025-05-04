package com.example.chat_apps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private Runnable runnable;
    private Intent loginIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Correct initialization of Intent
        loginIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(loginIntent);
                finish();
            }
        };
        handler.postDelayed(runnable, 4000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}