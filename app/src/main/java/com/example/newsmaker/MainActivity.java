package com.example.newsmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import android.content.pm.PackageManager;
import com.example.newsmaker.models.Article;
import com.example.newsmaker.models.ResponseModel;
import com.example.newsmaker.rests.APIClient;
import com.example.newsmaker.rests.APIInterface;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnNoteListener {
    private List<Article> articlesforviews=new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG);
         final String API_KEY = "b8987a26ed8b4150aa33396681940ee3";
        final RecyclerView recyclerView=findViewById(R.id.main_activity_rv);
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

       final APIInterface apiInterface=APIClient.getClient().create(APIInterface.class);
       Call<ResponseModel> call=apiInterface.getLatestNews(name,API_KEY);
       recyclerView.setLayoutManager(linearLayoutManager);

       call.enqueue(new Callback<ResponseModel>() {
           @Override
           public void onResponse(@NotNull Call<ResponseModel> call, @NotNull Response<ResponseModel> response) {
               if(response.body().getStatus().equals("ok"))
               {
                   articlesforviews=response.body().getArticles();
                   if(response.body().getTotalResults()>0)
                   {
                       MainAdapter mainAdapter=new MainAdapter(articlesforviews,MainActivity.this,MainActivity.this);

                       recyclerView.setAdapter(mainAdapter);
                   }
               }
           }

           @Override
           public void onFailure(Call<ResponseModel> call, Throwable t) {
               Log.e("out", t.toString());
           }
       });


    }

    @Override
    public void noteClick(int position) {
        articlesforviews.get(position);
        Intent intent=new Intent(this,Views.class);
        intent.putExtra("url", articlesforviews.get(position).getUrl());
        intent.putExtra("title", articlesforviews.get(position).getTitle());
        intent.putExtra("img",  articlesforviews.get(position).getUrlToImage());
        intent.putExtra("date",  articlesforviews.get(position).getPublishedAt());
        intent.putExtra("source",  articlesforviews.get(position).getSource().getName());
        intent.putExtra("author",  articlesforviews.get(position).getAuthor());
        intent.putExtra("content",articlesforviews.get(position).getContent());
                startActivity(intent);
    }
}

