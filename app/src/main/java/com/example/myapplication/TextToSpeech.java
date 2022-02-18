package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class TextToSpeech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_to_speech);
    }


    public void speak(View vew)
    {
        Intent listen = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        listen.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        listen.putExtra(RecognizerIntent.EXTRA_PROMPT,"Bol De");
        startActivityForResult(listen,1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1234)
        {
            ArrayList<String> list = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            Toast.makeText(this,list.get(0).toString(),Toast.LENGTH_LONG).show();
        }
    }
}