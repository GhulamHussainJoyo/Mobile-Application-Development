package com.example.myapplication.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class customAdapter extends AppCompatActivity {

    ListView listView;
    List userObjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User("Malook","03068233333"));
        arrayList.add(new User("jabbar","03068233333"));
        arrayList.add(new User("nazeeer","03068233333"));
        arrayList.add(new User("umair","030855585554"));
        arrayList.add(new User("tanveer","0301111111"));

        userObjects = arrayList;

        listView = findViewById(R.id.userData_ListView);
        UserDataAdapter userDataAdapter = new UserDataAdapter(this,R.layout.item,userObjects);
        listView.setAdapter(userDataAdapter);


    }
}