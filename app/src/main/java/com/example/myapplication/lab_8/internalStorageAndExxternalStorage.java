package com.example.myapplication.lab_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class internalStorageAndExxternalStorage extends AppCompatActivity {

//    actually this is lab 6 accoding to manual but here it is lab 8


    private TextInputEditText internalStorageText, externalStorageText;
    private Button saveInternalStorageButton, saveExternalStorageButton, loadInternalStorage, loadExternalStrage;

    String fileName = "internalStorage";
    String filePath = "";
    String fileContenets = "Ghulam Hussain Joyo";

    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_storage_and_exxternal_storage);

        internalStorageText = findViewById(R.id.internalStorageText);
        externalStorageText = findViewById(R.id.externalStorageText);
//      Buttons
        saveInternalStorageButton = findViewById(R.id.saveEntrnalStorageButton);
        saveExternalStorageButton = findViewById(R.id.saveExternalStorageButton);
        loadInternalStorage = findViewById(R.id.loadInternalStorageButton);
        loadExternalStrage = findViewById(R.id.loadExtrnalStorageButton);

        if(!isExternalStorageAvailableForRw())
        {
            saveExternalStorageButton.setEnabled(false);
        }

        saveInternalStorageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textFromEditText = internalStorageText.getText().toString().trim();
                internalStorageText.setText("");
                try {
                    outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(textFromEditText.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        });

        loadInternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File directory = getApplicationContext().getFilesDir();
                String dataFromFie = "";
                try {
                    File file = new File(directory, fileName);
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine())
                    {
                        dataFromFie+=myReader.nextLine();
                    }
                    internalStorageText.setText(dataFromFie.toString());
                    myReader.close();
                } catch (FileNotFoundException e) {
                    Log.v("An error occurred", "<---- error ---->");
                     e.printStackTrace();
                }

            }
        });

        saveExternalStorageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fileContent = externalStorageText.getText().toString().trim();
                externalStorageText.setText("");

                if (!fileContent.equals(""))
                {
                    File myExternalFile = new File(getExternalFilesDir(filePath),fileName);
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(myExternalFile);
                        fos.write(fileContent.getBytes());

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    externalStorageText.setText("");
                    Toast.makeText(getApplicationContext(),"Saved into SD card",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"external storage input empty",Toast.LENGTH_LONG).show();
                }
            }
        });

        loadExternalStrage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileReader fr = null;
                File myExternal = new File(getExternalFilesDir(filePath),fileName);
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    fr = new FileReader(myExternal);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();
                    while (line != null )
                    {
                        stringBuilder.append(line);
                        line = br.readLine();
                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    externalStorageText.setText(stringBuilder.toString());

                }
            }
        });


    }

    public boolean isExternalStorageAvailableForRw()
    {
        String externalStorage = Environment.getExternalStorageState();
        if (externalStorage.equals(Environment.MEDIA_MOUNTED))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}