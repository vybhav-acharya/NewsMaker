package com.example.newsmaker.database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.newsmaker.R;
import com.example.newsmaker.Views;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MainRecentsActivity extends AppCompatActivity {
    private NoteVIewModel noteVIewModel;
    private NoteListAdapter noteListAdapter;
    List<Note> mNotes=new ArrayList<>();
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recents);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        NoteListAdapter noteListAdapter = new NoteListAdapter(this, new NoteListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Note note) {
                String mUrl=note.getUrl();

                loader_webView(mUrl);





            }

        });
        recyclerView.setAdapter(noteListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteVIewModel = new ViewModelProvider(this).get(NoteVIewModel.class);

        noteVIewModel.getmAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                noteListAdapter.setNotes(notes);
            }
        });

    }

    private void loader_webView(String mUrl) {
        Intent intent=new Intent(this,Views.class);
        intent.putExtra("url", mUrl);


        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack())
            web.goBack();
        else super.onBackPressed();
    }
}