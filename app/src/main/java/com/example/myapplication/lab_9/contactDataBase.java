package com.example.myapplication.lab_9;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class contactDataBase extends SQLiteOpenHelper
{
//    Database Name
    private static final String DATABASE_NAME =  "contacts";
    private static final int DATABASE_VERSION =  1;

//  Table Name
    private static final String TABLE_CONTACT =  "contact";
    private static final String KEY_ID =  "contact";
    private static final String KEY_NAME =  "name";
    private static final String KEY_EMAIL =  "email";
    private static final String KEY_PHONE =  "phone";
//    Context
    private Context context;


    public contactDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACT_TABLE =  "CREATE TABLE "  + TABLE_CONTACT + "( id INTEGER PRIMARY KEY, name TEXT, email TEXT, phone TEXT)";
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion != newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);
            onCreate(db);
        }
    }

    public void addContact(Contact contact)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();

        try
        {
            ContentValues values = new ContentValues();
            values.put(KEY_NAME,contact.getName());
            values.put(KEY_EMAIL,contact.getEmail());
            values.put(KEY_PHONE,contact.getPhone());

            db.insertOrThrow(TABLE_CONTACT,null,values);
            db.setTransactionSuccessful();
            Toast.makeText(context,"Added successfully into database",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Log.d("Add contact method -> ", "Error while trying to add post to database");
        }
        finally {
            db.endTransaction();
        }
    }

    public void addOrUpdateContact(Contact contact)
    {
        SQLiteDatabase db = getWritableDatabase();
        long userId =-1;
        db.beginTransaction();


        try {
            ContentValues newValues = new ContentValues();
            newValues.put("name",contact.getName());
            newValues.put("phone",contact.getPhone());
            newValues.put("email",contact.getEmail());

            int row  = db.update(TABLE_CONTACT,newValues,"name = ?",new String[]{contact.getName()});

            if (row == 1)
            {
                String contactSelectQuery = String.format("SELECT %s FROM %s WHERE s% = ?",KEY_ID,TABLE_CONTACT,KEY_PHONE);
                Cursor cursor = db.rawQuery(contactSelectQuery,new String[]{String.valueOf(contact.getPhone())});
                try {
                    if (cursor.moveToFirst())
                    {
                        userId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }

                }finally {
                    if (cursor != null && !cursor.isClosed())
                    {
                        cursor.close();
                    }
                }
            }
            else
            {
                userId = db.insertOrThrow(TABLE_CONTACT,null,newValues);
            }
        }
        catch (Exception e)
        {
            Log.d("addOrUpdate method -> ", "Error while trying to add or update user");
        }
        finally {
            db.endTransaction();
        }

    }



    public ArrayList<Contact> getAllContacts()
    {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
//        Select * from contacts
        String selectQuery = "SELECT * from "+TABLE_CONTACT;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        try {
            if (cursor.moveToFirst())
            {
                Log.d("contact Data base 1",cursor.getString(1));
                Log.d("contact Data base 2",cursor.getString(2));
                Log.d("contact Data base 3",cursor.getString(3));

                do {
                    contactList.add(new Contact(cursor.getString(1),cursor.getString(2),cursor.getString(3)));
                }
                while (cursor.moveToNext());
            }
        }
        catch (Exception e)
        {
            Log.d("getAllData","Error while trying to get posts from database");
        }
        finally {
            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
        }

        return contactList;
    }
}
