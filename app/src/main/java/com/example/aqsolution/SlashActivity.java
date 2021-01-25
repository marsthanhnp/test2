package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SlashActivity extends AppCompatActivity {
    private static int SLASH_TIMEOUT =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent =new Intent(SlashActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SLASH_TIMEOUT);
    }
}