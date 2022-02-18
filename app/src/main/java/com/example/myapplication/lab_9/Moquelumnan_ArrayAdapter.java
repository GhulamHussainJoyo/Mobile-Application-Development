package com.example.myapplication.lab_9;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.List;

public class Moquelumnan_ArrayAdapter extends ArrayAdapter<Moquelumnan_data>
{

    private Context mContext;
    private List<Moquelumnan_data> mMolquemanList;
    private int mResources;

    public Moquelumnan_ArrayAdapter(@NonNull Context context, int resource, List data) {
        super(context, resource, data);

        mContext = context;
        mMolquemanList = data;
        mResources = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.moquelumnan_item,null);

        ImageView img = view.findViewById(R.id.number_img);
        TextView counntText = view.findViewById(R.id.count_text);
        TextView counntNumrical = view.findViewById(R.id.count_number);

        Moquelumnan_data item = mMolquemanList.get(position);

        img.setImageResource(item.getImage());
        counntText.setText(item.getCountText());
        counntNumrical.setText(item.getCountNumrical());

        return view;
    }

}
