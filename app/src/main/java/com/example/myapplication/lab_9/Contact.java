package com.example.myapplication.lab_9;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable
{
    private String name;
    private String email;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Contact()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
    // TODO Auto-generated method stub

        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.phone);
    }

    public Contact(Parcel in) {
        name = in.readString();
        email = in.readString();
        phone = in.readString();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

}
