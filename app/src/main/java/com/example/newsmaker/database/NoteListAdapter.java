package com.example.newsmaker.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsmaker.R;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>{
    private final LayoutInflater layoutInflater;
    private Context mcontext;
    List<Note> mNotes;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    public NoteListAdapter(Context context,OnItemClickListener listener) {
        layoutInflater=LayoutInflater.from(context);
        mcontext=context;
        this.listener=listener;


    }

    @NonNull
    @Override
    public NoteListAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=layoutInflater.inflate(R.layout.list_item,parent,false);
        NoteViewHolder viewHolder=new NoteViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteListAdapter.NoteViewHolder holder, int position) {
        if (mNotes != null) {
            Note note = mNotes.get(position);
            holder.bind(mNotes.get(position), listener,position);




        }
    }

    @Override
    public int getItemCount() {
        if (mNotes != null)
            return mNotes.size();
        else return 0;
    }

    public void setNotes(List<Note> Notes) {
        mNotes = Notes;
        notifyDataSetChanged();
    }


    public class NoteViewHolder extends RecyclerView.ViewHolder  {

        private TextView titleView,authorView;
        private ImageView imageView;
        private int mPosition;



        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.txvTitle);
            authorView = itemView.findViewById(R.id.txvAuthor);
            imageView=itemView.findViewById(R.id.imageView);

        }



        public void bind(Note note, OnItemClickListener listener,int Position) {
            String author= note.getAuthor();
            String title= note.getTitle();
            titleView.setText(title);
            authorView.setText(author);
            Glide.with(mcontext)
                    .load(note.getUrltoimage())

                    .into(imageView);
            mPosition=Position;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(note);
                }
            });

        }
    }

}