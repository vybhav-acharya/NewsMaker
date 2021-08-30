package com.example.newsmaker;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsmaker.models.Article;
import com.example.newsmaker.models.ResponseModel;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Callback;

public  class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> implements OnNoteListener {


    private final List<Article> array_articles;
    private LayoutInflater inflater;
    Context context;
    private ViewGroup parent;
    private int viewType;

    private OnNoteListener mNoteListener;
    public MainAdapter(List<Article> array_articles,Context context, OnNoteListener mNoteListener) {
        inflater=LayoutInflater.from(context);
        this.array_articles = array_articles;
        this.mNoteListener=mNoteListener;
        this.context=context;
    }




    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        this.parent = parent;
        this.viewType = viewType;
        View views=inflater.inflate(R.layout.list_item, parent, false);

        return new MainAdapter.ViewHolder(views,mNoteListener);
    }



    @Override

    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        final Article now = array_articles.get(position);
        if (!TextUtils.isEmpty(now.getTitle())) {
            holder.titleView.setText(now.getTitle());
        }
        if (!TextUtils.isEmpty(now.getAuthor())) {
            String noww="By:"+now.getAuthor();
            holder.authorView.setText(noww);
        }


        Glide.with(context)
                .load(now.getUrlToImage())

                .into(holder.imageView);


    }
    @Override
    public int getItemCount() {
        return array_articles.size();
    }

    @Override
    public void noteClick(int position) {

    }


    public class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView,authorView;

        ImageView imageView;
        OnNoteListener oneNoteListener;


        public ViewHolder(View itemView,OnNoteListener oneNoteListener) {
            super(itemView);
            this.titleView = itemView.findViewById(R.id.txvTitle);
            this.authorView=itemView.findViewById(R.id.txvAuthor);
            this.imageView = itemView.findViewById(R.id.imageView);

            this.oneNoteListener=oneNoteListener;
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
        oneNoteListener.noteClick(getAdapterPosition());
        }
    }



}
interface OnNoteListener{
    void noteClick(int position);
}




