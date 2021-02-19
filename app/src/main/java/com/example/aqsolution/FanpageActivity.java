package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class FanpageActivity extends AppCompatActivity {
    WebView webView;

//    Toolbar toolbar;
//    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fanpage);


//        drawerLayout=findViewById(R.id.drawer_layout);
//        toolbar=findViewById(R.id.toolbar);

        webView=findViewById(R.id.webView_Fanpage);
        Intent intent=getIntent();
        String link=intent.getStringExtra("link_fanpage");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());


//        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_menu25x25);
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
    }
}