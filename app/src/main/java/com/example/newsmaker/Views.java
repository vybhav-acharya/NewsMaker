package com.example.newsmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.newsmaker.database.Note;
import com.example.newsmaker.database.NoteVIewModel;
import com.example.newsmaker.models.Article;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Views extends AppCompatActivity {
    private String mUrl, mImg, mTitle, mDate, mSource, mAuthor;
    private ImageView imageView;
    private TextView appbar_title,author,date, time, title_1,content;
    private WebView web;
    private NoteVIewModel noteVIewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        Intent intent = getIntent();

        mUrl = intent.getStringExtra("url");
        mAuthor=intent.getStringExtra("author");
        mTitle=intent.getStringExtra("title");
        mImg=intent.getStringExtra("urltoimage");

        web=findViewById(R.id.webview);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(mUrl);
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if(!TextUtils.isEmpty(mAuthor)) {
            noteVIewModel = new ViewModelProvider(this).get(NoteVIewModel.class);
            String note_id = UUID.randomUUID().toString();

            Note note = new Note(note_id, mTitle, mAuthor, mUrl, mImg);
            noteVIewModel.insert(note);
        }



    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack())
            web.goBack();
        else super.onBackPressed();
    }
}