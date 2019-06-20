package com.example.recyclerviewassignment.model;

public class Post {
    private int image;
    private String title;
    public Post(){}

    public Post(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
