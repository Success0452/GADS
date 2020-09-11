package com.famous.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Start_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);


        int SPLASH_DISPLAY_LENGTH = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Start_Activity.this, MainActivity.class);
                Start_Activity.this.startActivity(mainIntent);
                Start_Activity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}