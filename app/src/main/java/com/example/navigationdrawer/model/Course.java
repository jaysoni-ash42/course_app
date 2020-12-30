package com.example.navigationdrawer.model;

public class Course {
    private String link,name;

    public Course() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course(String link, String name) {
        this.link = link;
        this.name = name;
    }
}
