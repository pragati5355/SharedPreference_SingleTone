package com.example.sharedpreference_singletone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText edtFName,edtEmail,edtpassword;
    Button btnLogin;

    SharedPreference sharedPreference;

    String correct_password = "gawade55";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFName = findViewById(R.id.EdtName);
        edtEmail = findViewById(R.id.EdtEmail);
        edtpassword = findViewById(R.id.Edtpassword);
        btnLogin = findViewById(R.id.Loginbtn);

        sharedPreference = new SharedPreference(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(edtpassword.getText().toString())){
                    Toast.makeText(MainActivity.this,"Data Provided Empty",Toast.LENGTH_LONG).show();
                }
                else{

                    if(edtpassword.getText().toString().equals(correct_password)){
                        Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_LONG).show();
                    }
                }

                sharedPreference.setFirstName(edtFName.getText().toString().trim());
                sharedPreference.setEmailName(edtEmail.getText().toString().trim());
                sharedPreference.setPassword(edtpassword.getText().toString().trim());
                sharedPreference.setIsLogin(true);

            }
        });



    }
}