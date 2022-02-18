package com.example.myapplication.lab_9;

public class Moquelumnan_data
{
    private int image;
    private String countText;
    private String countNumrical;

    public Moquelumnan_data(int image, String countText, String countNumrical) {
        this.image = image;
        this.countText = countText;
        this.countNumrical = countNumrical;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCountText() {
        return countText;
    }

    public void setCountText(String countText) {
        this.countText = countText;
    }

    public String getCountNumrical() {
        return countNumrical;
    }

    public void setCountNumrical(String countNumrical) {
        this.countNumrical = countNumrical;
    }
}
