package com.example.sharedpreference_singletone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FirstActivity extends AppCompatActivity {

    SharedPreference sharedPreference;

    private static int Time_out = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        sharedPreference = new SharedPreference(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPreference.getIsLogin()) {
                    startActivity(new Intent(FirstActivity.this, MainActivity2.class));
                    finish();
                } else {
                    startActivity(new Intent(FirstActivity.this, MainActivity.class));
                    finish();

                }
            }
        }, Time_out);
    }
}