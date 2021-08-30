package com.example.newsmaker.database;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteVIewModel extends AndroidViewModel {
    private String TAG = this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase noteRoomDatabase;
    private LiveData<List<Note>> mAllNotes;


    public NoteVIewModel(@NonNull Application application) {
        super(application);
        noteRoomDatabase=NoteRoomDatabase.getDatabase(application);
        noteDao=noteRoomDatabase.noteDao();
        mAllNotes=noteDao.getAllNotes();
    }

    public void insert(Note note)
    {
        new InsertAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getmAllNotes() {
        return mAllNotes;
    }

    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }


    private class OperationsAsyncTask extends AsyncTask<Note, Void, Void> {

        NoteDao mAsyncTaskDao;

        OperationsAsyncTask(NoteDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
    }

    private class InsertAsyncTask extends OperationsAsyncTask {

        InsertAsyncTask(NoteDao mNoteDao) {
            super(mNoteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.insert(notes[0]);
            return null;
        }
    }
}
