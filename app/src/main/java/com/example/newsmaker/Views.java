package com.example.newsmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.text.DateFormat;

public class Views extends AppCompatActivity {
    private String mUrl, mImg, mTitle, mDate, mSource, mAuthor,mContent;
    private ImageView imageView;
    private TextView appbar_title,author,date, time, title_1,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        ProgressDialog pd= new ProgressDialog(this);;
        pd.setMessage("Getting the posts");
        pd.show();
        WebView web=findViewById(R.id.webview);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(mUrl);
        pd.dismiss();


    }
}