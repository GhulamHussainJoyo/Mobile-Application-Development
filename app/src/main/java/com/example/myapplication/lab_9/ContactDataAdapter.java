package com.example.myapplication.lab_9;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.List;

public class ContactDataAdapter extends ArrayAdapter<Contact> {

    private int mResources;
    private Context context;
    private List<Contact> contactList = null;


    public ContactDataAdapter(@NonNull Context context, int resource, List list) {
        super(context, resource, list);
        this.context = context;
        this.mResources = resource;
        this.contactList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = View.inflate(context, R.layout.contact_row_item, null);


        TextView nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        TextView emailTextView = (TextView) view.findViewById(R.id.emailTextView);
        TextView phoneTextView = (TextView) view.findViewById(R.id.phoneTextView);


        Contact contact = contactList.get(position);

//        Log.d("contact Data Adapter", contact.getName());
//        Log.d("contact Data Adapter", contact.getEmail());
//        Log.d("contact Data Adapter", contact.getPhone());

        nameTextView.setText(contact.getName());
        emailTextView.setText(contact.getEmail());
        phoneTextView.setText(contact.getPhone());


        return view;

    }
}
