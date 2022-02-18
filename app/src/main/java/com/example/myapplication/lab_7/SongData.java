package com.example.myapplication.lab_7;

import android.database.Cursor;
import android.provider.MediaStore;

public class SongData
{

    public String artist;
    public String title;
    public String path;


    public SongData(String artist, String title, String path) {
        this.artist = artist;
        this.title = title;
        this.path = path;
    }

    public SongData( String title, String path) {
        this.title = title;
        this.path = path;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
