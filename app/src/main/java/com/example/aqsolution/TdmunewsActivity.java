package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TdmunewsActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdmunews);

        webView=findViewById(R.id.webView_Tdmunews);

        Intent intent=getIntent();
        String link=intent.getStringExtra("link_tdmunews");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());


        WebSettings webSettings=webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
    }
}