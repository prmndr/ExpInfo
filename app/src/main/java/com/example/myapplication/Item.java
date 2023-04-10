package com.example.myapplication;

public class Item {

    private String title;
    private String desc;
    private String time;
    private String date;

    public Item(String title, String desc, String time, String date) {
        this.title = title;
        this.desc = desc;
        this.time = time;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
