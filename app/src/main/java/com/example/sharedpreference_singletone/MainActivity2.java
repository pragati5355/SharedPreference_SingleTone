package com.example.sharedpreference_singletone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtname,txtemail;
    Button btnLogout;

    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreference = new SharedPreference(this);

        txtname = findViewById(R.id.Txtname);
        txtemail = findViewById(R.id.Txtemail);
        btnLogout = findViewById(R.id.Logoutbtn);

        txtname.setText(sharedPreference.getFirstName());
        txtemail.setText(sharedPreference.getEmailName());


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreference.setIsLogin(false);
                finish();
            }
        });


    }
}