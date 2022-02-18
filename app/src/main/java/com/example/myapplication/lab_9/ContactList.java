package com.example.myapplication.lab_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity {

    private ListView contactListView;
    private contactDataBase dataBase;
    private Context addUserContext;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        Bundle bundle = getIntent().getExtras();
        contactList = bundle.getParcelableArrayList("contactList");

        Toast.makeText(this, contactList.get(0).getPhone(), Toast.LENGTH_LONG).show();

        contactListView = findViewById(R.id.contact_listView);
        ContactDataAdapter adapter = new ContactDataAdapter(this,R.layout.contact_row_item,contactList);
        contactListView.setAdapter(adapter);

    }
}