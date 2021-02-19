package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aqsolution.TokenClass;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    TextView tV_hoten, tV_email, tV_username;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tV_hoten=findViewById(R.id.tv_hoten);
        tV_email=findViewById(R.id.tv_email);
        tV_username=findViewById(R.id.tv_username);

        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
        tV_hoten.setText(sharedPreferences.getString("rmb_name",""));
        tV_email.setText(sharedPreferences.getString("rmb_principal",""));
        tV_username.setText(sharedPreferences.getString("rmb_username",""));
    }
    
}