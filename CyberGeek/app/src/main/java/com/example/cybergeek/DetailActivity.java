package com.example.cybergeek;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import androidx.appcompat.widget.Toolbar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    ProgressBar progressbar;
    Toolbar toolbar;
    WebView webView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        progressbar=findViewById(R.id.progressbar);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        webView=findViewById(R.id.detailView);
        setSupportActionBar(toolbar);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Toast.makeText(DetailActivity.this, "Page Started Loading..", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                Toast.makeText(DetailActivity.this, "Page Loaded..", Toast.LENGTH_SHORT).show();
            }
        });
        webView.loadUrl(getIntent().getStringExtra("url"));
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }
}