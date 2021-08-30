package com.example.newsmaker.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_shit",indices = {@Index(value = {"url"},
        unique = true)})
public class Note {
    @PrimaryKey
    @NonNull
    public String id;


    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "author")
    public String author;
    @ColumnInfo(name = "url")
    public String url;

    public Note(@NonNull String id, String title, String author, String url, String urltoimage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.url = url;
        this.urltoimage = urltoimage;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public void setUrltoimage(String urltoimage) {
        this.urltoimage = urltoimage;
    }

    @ColumnInfo(name = "urltoimage")
    public String urltoimage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
