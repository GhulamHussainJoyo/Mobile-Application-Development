package com.example.myapplication.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class mp3Player extends AppCompatActivity {


    private ImageButton previousBtn, playBtn, nextBtn;
    public TextView songName, startTimeField, endTimeField;
    private SeekBar seekbar;
    private ImageButton playButton, pauseButton;
    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    ;
    private int forwardTime = 5000;
    private int backwardTime = 5000;

    public static int oneTimeOnly = 0;
    public static boolean playButtonChecked = false;
    public ArrayList<SongData> songList;
    public int songIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_player);
//      Get All songs
        songList = getAudioList();
        Log.v("All Songs ---->  ", "total no of songs are=" + songList.size());
//      media players


        mediaPlayer = new MediaPlayer();

        String songPath = "file:///" + songList.get(songIndex).getPath();

        Log.v("tite ----> ", songList.get(songIndex).getTitle());
        Log.v("path  ----> ", songList.get(songIndex).getPath());


        try {

            //mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(songList.get(songIndex).getPath());
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        mediaPlayer = MediaPlayer.create(this,uri);

//      constrols
        previousBtn = findViewById(R.id.previousBtn);
        playBtn = findViewById(R.id.playBtn);
        nextBtn = findViewById(R.id.nextBtn);

        seekbar = (SeekBar) findViewById(R.id.mp3Seekbar);
        startTimeField = findViewById(R.id.startTimeField);
        endTimeField = findViewById(R.id.endTimeField);

        seekbar.setClickable(false);


    }

    public void Music(View view) {
        switch (view.getId()) {
            case R.id.previousBtn:
//                do someThing
                break;

            case R.id.playBtn:
                if (playButtonChecked == true) {
                    pause();
                } else {
                    play();
                }


                break;

            case R.id.nextBtn:
//                do someThing
                break;


        }
    }


    public void nextSong() {

    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public void play() {
        Toast.makeText(getApplicationContext(), "Playing sound",
                Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        playBtn.setImageResource(R.mipmap.pause);

        playButtonChecked = true;
        //mediaPlayer.start();
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        if (oneTimeOnly == 0) {
            seekbar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }

        endTimeField.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                toMinutes((long) finalTime)))
        );

        startTimeField.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                toMinutes((long) startTime)))
        );

        seekbar.setProgress((int) startTime);
        myHandler.postDelayed(UpdateSongTime, 100);


    }


    private Runnable UpdateSongTime = new Runnable() {
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            startTimeField.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };


    public void pause() {
        Toast.makeText(getApplicationContext(), "Pausing sound",
                Toast.LENGTH_SHORT).show();

        playBtn.setImageResource(R.mipmap.play);
        playButtonChecked = false;
        mediaPlayer.pause();
//        pauseButton.setEnabled(false);
//        playButton.setEnabled(true);
    }


    public void forward(View view) {
        int temp = (int) startTime;
        if ((temp + forwardTime) <= finalTime) {
            startTime = startTime + forwardTime;
            mediaPlayer.seekTo((int) startTime);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Cannot jump forward 5 seconds",
                    Toast.LENGTH_SHORT).show();
        }

    }


    public void rewind(View view) {
        int temp = (int) startTime;
        if ((temp - backwardTime) > 0) {
            startTime = startTime - backwardTime;
            mediaPlayer.seekTo((int) startTime);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Cannot jump backward 5 seconds",
                    Toast.LENGTH_SHORT).show();
        }

    }


    public ArrayList<SongData> getAudioList() {

        ArrayList<SongData> mSongsList = new ArrayList<SongData>();
        Cursor mCursor = getContentResolver()
                .query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        new String[]{MediaStore.Audio.Media.DISPLAY_NAME,
                                MediaStore.Audio.Media.DATA}, null, null, null);

        int count = mCursor.getCount();

        SongData songData;

        while (mCursor.moveToNext()) {

            String title = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
            String path = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));

            songData = new SongData(title, path);

            mSongsList.add(songData);
        }
        mCursor.close();
        return mSongsList;
    }


}