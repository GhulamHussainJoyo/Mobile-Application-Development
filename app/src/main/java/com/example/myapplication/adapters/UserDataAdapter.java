package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.List;

public class UserDataAdapter extends ArrayAdapter<User>
{
    int mResource;
    Context mContext;
    List<User> userList = null;
    public UserDataAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        userList = objects;
        mContext = context;
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item,null);
        TextView name  = view.findViewById(R.id.name);
        TextView phone  = view.findViewById(R.id.phone);

        User user = userList.get(position);

        name.setText(user.getName());
        phone.setText(user.getPhone());

        return view;


    }
}
