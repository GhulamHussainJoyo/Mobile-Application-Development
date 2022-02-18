package com.example.myapplication.lab_9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//    actually this is lab 7 accoding to manual

public class addUser extends AppCompatActivity {


    private static final int SELECT_PICTURE = 0;

//  Database
    private contactDataBase dataBase;
    TextInputEditText name_editText, email_editText, phone_editText;
    Button add_btn,finish_btn;
    ImageView userImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);
        userImage = findViewById(R.id.userImage_imageView);
        name_editText = findViewById(R.id.name_editText);
        email_editText = findViewById(R.id.email_editText);
        phone_editText = findViewById(R.id.phone_editText);
        add_btn = findViewById(R.id.add_btn);
        finish_btn = findViewById(R.id.finish_btn);
        dataBase = new contactDataBase(this);



    }

    public void finishActivity(View view)
    {
        Intent intent = new Intent(this,ContactList.class);
        ArrayList<Contact> list = dataBase.getAllContacts();
        Toast.makeText(this,list.get(0).getPhone(),Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contactList", list);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void AddIntoDatabase(View view)
    {
        String name = name_editText.getText().toString().trim();
        String email = email_editText.getText().toString().trim();
        String phone = phone_editText.getText().toString().trim();

        if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty())
        {
            dataBase.addContact(new Contact(name,email,phone));
        }
    }

    public void selectImage(View view)
    {
        Intent image_intent = new Intent();
        image_intent.setType("image/*");
        image_intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(image_intent,"Select Image"),SELECT_PICTURE);
    }

    private Bitmap getPath(Uri uri)
    {
        String[] projectoin = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri,projectoin,null,null,null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String filePath = cursor.getString(column_index);
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        return bitmap;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            Bitmap bitmap = getPath(data.getData());
            userImage.setImageBitmap(bitmap);
        }
    }
}