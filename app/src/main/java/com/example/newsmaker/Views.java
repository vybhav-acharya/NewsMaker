package com.example.newsmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
        mImg = intent.getStringExtra("img");
        mTitle = intent.getStringExtra("title");
        mDate = intent.getStringExtra("date");
        mSource="Source: ";
        mAuthor="Author :";
        mSource += intent.getStringExtra("source");
        mAuthor += intent.getStringExtra("author");

        imageView=findViewById(R.id.imageView);

       title_1=findViewById(R.id.title_1);
        content=findViewById(R.id.content);
        author=findViewById(R.id.author);
        date=findViewById(R.id.date);


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(Utils.getRandomDrawbleColor());

        Glide.with(this)
                .load(mImg)

                .into(imageView);

        String dates= Utils.DateFormat(mDate);

        title_1.setText(mTitle);
        content.setText(mSource);
        author.setText(mAuthor);
        date.setText(dates);






        Toast.makeText(this, "Boss you rock", Toast.LENGTH_SHORT).show();
    }
}