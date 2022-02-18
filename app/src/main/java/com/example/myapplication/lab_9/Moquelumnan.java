package com.example.myapplication.lab_9;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Moquelumnan extends AppCompatActivity {


    ListView listView;
    List<Moquelumnan_data> moquelmunList;
    List moquelumanAudio;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moquelumnan);

        moquelmunList = getArrayList();
        moquelumanAudio = getAudioArrayList();

        listView = findViewById(R.id.listView_molqMan);
        Moquelumnan_ArrayAdapter adapter = new Moquelumnan_ArrayAdapter(this, R.layout.moquelumnan_item, moquelmunList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {

                mediaPlayer = null;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), (Integer) moquelumanAudio.get(position));
                mediaPlayer.start();
                listView.setClickable(false);

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                        listView.setClickable(true);

                    }
                });

                Toast.makeText(getApplicationContext(),position+" ",Toast.LENGTH_LONG).show();
            }
        });



    }

    private ArrayList<Moquelumnan_data> getArrayList() {
        ArrayList<Moquelumnan_data> arrayList = new ArrayList<>();
        arrayList.add(new Moquelumnan_data(R.mipmap.number_one, "One", "1"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_two, "Two", "2"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_three, "Three", "3"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_four, "Four", "4"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_five, "Five", "5"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_six, "Six", "6"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_seven, "Seven", "7"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_eight, "Eight", "8"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_nine, "Nine", "9"));
        arrayList.add(new Moquelumnan_data(R.mipmap.number_ten, "Ten", "10"));
        return arrayList;

    }

    private ArrayList<Integer> getAudioArrayList()
    {
        ArrayList<Integer> audio = new ArrayList<>();
        audio.add(R.raw.number_one);
        audio.add(R.raw.number_two);
        audio.add(R.raw.number_three);
        audio.add(R.raw.number_four);
        audio.add(R.raw.number_five);
        audio.add(R.raw.number_six);
        audio.add(R.raw.number_seven);
        audio.add(R.raw.number_eight);
        audio.add(R.raw.number_nine);
        audio.add(R.raw.number_ten);

        return audio;
    }
}