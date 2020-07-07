package com.example.hw2.recycler;


public class mydata {
    public boolean isOfficial;
    public String title;
    public String time;
    public String description;
    public String icon;
    public mydata(String title, String time,String description,String icon,boolean iso) {
        this.title = title;
        this.time = time;
        this.description=description;
        this.icon=icon;
        this.isOfficial=iso;
    }
}